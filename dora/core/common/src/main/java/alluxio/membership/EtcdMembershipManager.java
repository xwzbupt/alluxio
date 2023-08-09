/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.membership;

import alluxio.conf.AlluxioConfiguration;
import alluxio.conf.PropertyKey;
import alluxio.exception.status.AlreadyExistsException;
import alluxio.wire.WorkerInfo;

import com.google.common.annotations.VisibleForTesting;
import io.etcd.jetcd.KeyValue;
import org.apache.zookeeper.server.ByteBufferInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MembershipManager backed by configured etcd cluster.
 */
public class EtcdMembershipManager implements MembershipManager {
  private static final Logger LOG = LoggerFactory.getLogger(EtcdMembershipManager.class);
  private static final String RING_PATH_FORMAT = "/DHT/%s/AUTHORIZED/";
  private final AlluxioConfiguration mConf;
  private AlluxioEtcdClient mAlluxioEtcdClient;
  private String mClusterName;
  private String mRingPathPrefix = "";

  /**
   * @param conf
   * @return EtcdMembershipManager
   */
  public static EtcdMembershipManager create(AlluxioConfiguration conf) {
    return new EtcdMembershipManager(conf);
  }

  /**
   * CTOR for EtcdMembershipManager.
   * @param conf
   */
  public EtcdMembershipManager(AlluxioConfiguration conf) {
    this(conf, AlluxioEtcdClient.getInstance(conf));
  }

  /**
   * CTOR for EtcdMembershipManager with given AlluxioEtcdClient client.
   * @param conf
   * @param alluxioEtcdClient
   */
  public EtcdMembershipManager(AlluxioConfiguration conf, AlluxioEtcdClient alluxioEtcdClient) {
    mConf = conf;
    mClusterName = conf.getString(PropertyKey.ALLUXIO_CLUSTER_NAME);
    mRingPathPrefix = String.format(RING_PATH_FORMAT, mClusterName);
    mAlluxioEtcdClient = alluxioEtcdClient;
  }

  @Override
  public void join(WorkerInfo wkrAddr) throws IOException {
    WorkerServiceEntity entity = new WorkerServiceEntity(wkrAddr.getAddress());
    // 1) register to the ring
    String pathOnRing = new StringBuffer()
        .append(mRingPathPrefix)
        .append(entity.getServiceEntityName()).toString();
    byte[] ret = mAlluxioEtcdClient.getForPath(pathOnRing);
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
         DataOutputStream dos = new DataOutputStream(baos)) {
      entity.serialize(dos);
      byte[] serializedEntity = baos.toByteArray();
      // If there's existing entry, check if it's me.
      if (ret != null) {
        // It's not me, something is wrong.
        if (!Arrays.equals(serializedEntity, ret)) {
          throw new AlreadyExistsException(
              "Some other member with same id registered on the ring, bail.");
        }
        // It's me, go ahead to start heartbeating.
      } else {
        // If haven't created myself onto the ring before, create now.
        mAlluxioEtcdClient.createForPath(pathOnRing, Optional.of(serializedEntity));
      }
      // 2) start heartbeat
      mAlluxioEtcdClient.mServiceDiscovery.registerAndStartSync(entity);
    }
  }

  @Override
  public List<WorkerInfo> getAllMembers() throws IOException {
    List<WorkerServiceEntity> registeredWorkers = retrieveFullMembers();
    return registeredWorkers.stream()
        .map(e -> new WorkerInfo().setAddress(e.getWorkerNetAddress()))
        .collect(Collectors.toList());
  }

  private List<WorkerServiceEntity> retrieveFullMembers() throws IOException {
    List<WorkerServiceEntity> fullMembers = new ArrayList<>();
    List<KeyValue> childrenKvs = mAlluxioEtcdClient.getChildren(mRingPathPrefix);
    for (KeyValue kv : childrenKvs) {
      try (ByteArrayInputStream bais =
               new ByteArrayInputStream(kv.getValue().getBytes());
           DataInputStream dis = new DataInputStream(bais)) {
        WorkerServiceEntity entity = new WorkerServiceEntity();
        entity.deserialize(dis);
        fullMembers.add(entity);
      } catch (IOException ex) {
        // Ignore
      }
    }
    return fullMembers;
  }

  private List<WorkerServiceEntity> retrieveLiveMembers() throws IOException {
    List<WorkerServiceEntity> liveMembers = new ArrayList<>();
    for (Map.Entry<String, ByteBuffer> entry : mAlluxioEtcdClient.mServiceDiscovery
        .getAllLiveServices().entrySet()) {
      try (ByteBufferInputStream bbis =
               new ByteBufferInputStream(entry.getValue());
           DataInputStream dis = new DataInputStream(bbis)) {
        WorkerServiceEntity entity = new WorkerServiceEntity();
        entity.deserialize(dis);
        liveMembers.add(entity);
      } catch (IOException ex) {
        // Ignore
      }
    }
    return liveMembers;
  }

  @Override
  @VisibleForTesting
  public List<WorkerInfo> getLiveMembers() throws IOException {
    List<WorkerServiceEntity> liveWorkers = retrieveLiveMembers();
    return liveWorkers.stream()
        .map(e -> new WorkerInfo().setAddress(e.getWorkerNetAddress()))
        .collect(Collectors.toList());
  }

  @Override
  @VisibleForTesting
  public List<WorkerInfo> getFailedMembers() throws IOException {
    List<WorkerServiceEntity> registeredWorkers = retrieveFullMembers();
    List<String> liveWorkers = retrieveLiveMembers()
        .stream().map(e -> e.getServiceEntityName())
        .collect(Collectors.toList());
    registeredWorkers.removeIf(e -> liveWorkers.contains(e.getServiceEntityName()));
    return registeredWorkers.stream()
        .map(e -> new WorkerInfo().setAddress(e.getWorkerNetAddress()))
        .collect(Collectors.toList());
  }

  @Override
  @VisibleForTesting
  public String showAllMembers() {
    try {
      List<WorkerServiceEntity> registeredWorkers = retrieveFullMembers();
      List<String> liveWorkers = retrieveLiveMembers().stream().map(
          w -> w.getServiceEntityName()).collect(Collectors.toList());
      String printFormat = "%s\t%s\t%s%n";
      StringBuilder sb = new StringBuilder(
          String.format(printFormat, "WorkerId", "Address", "Status"));
      for (WorkerServiceEntity entity : registeredWorkers) {
        String entryLine = String.format(printFormat,
            entity.getServiceEntityName(),
            entity.getWorkerNetAddress().getHost() + ":"
                + entity.getWorkerNetAddress().getRpcPort(),
            liveWorkers.contains(entity.getServiceEntityName()) ? "ONLINE" : "OFFLINE");
        sb.append(entryLine);
      }
      return sb.toString();
    } catch (IOException ex) {
      return String.format("Exception happened:%s", ex.getMessage());
    }
  }

  @Override
  public void stopHeartBeat(WorkerInfo worker) throws IOException {
    WorkerServiceEntity entity = new WorkerServiceEntity(worker.getAddress());
    mAlluxioEtcdClient.mServiceDiscovery.unregisterService(entity.getServiceEntityName());
  }

  @Override
  public void decommission(WorkerInfo worker) throws IOException {
    // TO BE IMPLEMENTED
  }

  @Override
  public void close() throws Exception {
    // NOTHING TO CLOSE
  }
}