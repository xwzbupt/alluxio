// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc/table/table_master.proto

package alluxio.grpc.table;

/**
 * Protobuf type {@code alluxio.grpc.table.Constraint}
 */
public  final class Constraint extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:alluxio.grpc.table.Constraint)
    ConstraintOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Constraint.newBuilder() to construct.
  private Constraint(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Constraint() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Constraint();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Constraint(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              columnConstraints_ = com.google.protobuf.MapField.newMapField(
                  ColumnConstraintsDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<java.lang.String, alluxio.grpc.table.Domain>
            columnConstraints__ = input.readMessage(
                ColumnConstraintsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            columnConstraints_.getMutableMap().put(
                columnConstraints__.getKey(), columnConstraints__.getValue());
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return alluxio.grpc.table.TableMasterProto.internal_static_alluxio_grpc_table_Constraint_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 1:
        return internalGetColumnConstraints();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return alluxio.grpc.table.TableMasterProto.internal_static_alluxio_grpc_table_Constraint_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            alluxio.grpc.table.Constraint.class, alluxio.grpc.table.Constraint.Builder.class);
  }

  public static final int COLUMN_CONSTRAINTS_FIELD_NUMBER = 1;
  private static final class ColumnConstraintsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, alluxio.grpc.table.Domain> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, alluxio.grpc.table.Domain>newDefaultInstance(
                alluxio.grpc.table.TableMasterProto.internal_static_alluxio_grpc_table_Constraint_ColumnConstraintsEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                alluxio.grpc.table.Domain.getDefaultInstance());
  }
  private com.google.protobuf.MapField<
      java.lang.String, alluxio.grpc.table.Domain> columnConstraints_;
  private com.google.protobuf.MapField<java.lang.String, alluxio.grpc.table.Domain>
  internalGetColumnConstraints() {
    if (columnConstraints_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          ColumnConstraintsDefaultEntryHolder.defaultEntry);
    }
    return columnConstraints_;
  }

  public int getColumnConstraintsCount() {
    return internalGetColumnConstraints().getMap().size();
  }
  /**
   * <pre>
   * maps column to constraint, columns not present are not constrained
   * </pre>
   *
   * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
   */

  public boolean containsColumnConstraints(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetColumnConstraints().getMap().containsKey(key);
  }
  /**
   * Use {@link #getColumnConstraintsMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, alluxio.grpc.table.Domain> getColumnConstraints() {
    return getColumnConstraintsMap();
  }
  /**
   * <pre>
   * maps column to constraint, columns not present are not constrained
   * </pre>
   *
   * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
   */

  public java.util.Map<java.lang.String, alluxio.grpc.table.Domain> getColumnConstraintsMap() {
    return internalGetColumnConstraints().getMap();
  }
  /**
   * <pre>
   * maps column to constraint, columns not present are not constrained
   * </pre>
   *
   * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
   */

  public alluxio.grpc.table.Domain getColumnConstraintsOrDefault(
      java.lang.String key,
      alluxio.grpc.table.Domain defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, alluxio.grpc.table.Domain> map =
        internalGetColumnConstraints().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <pre>
   * maps column to constraint, columns not present are not constrained
   * </pre>
   *
   * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
   */

  public alluxio.grpc.table.Domain getColumnConstraintsOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, alluxio.grpc.table.Domain> map =
        internalGetColumnConstraints().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetColumnConstraints(),
        ColumnConstraintsDefaultEntryHolder.defaultEntry,
        1);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (java.util.Map.Entry<java.lang.String, alluxio.grpc.table.Domain> entry
         : internalGetColumnConstraints().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, alluxio.grpc.table.Domain>
      columnConstraints__ = ColumnConstraintsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, columnConstraints__);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof alluxio.grpc.table.Constraint)) {
      return super.equals(obj);
    }
    alluxio.grpc.table.Constraint other = (alluxio.grpc.table.Constraint) obj;

    if (!internalGetColumnConstraints().equals(
        other.internalGetColumnConstraints())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (!internalGetColumnConstraints().getMap().isEmpty()) {
      hash = (37 * hash) + COLUMN_CONSTRAINTS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetColumnConstraints().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static alluxio.grpc.table.Constraint parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.table.Constraint parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.table.Constraint parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.table.Constraint parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.table.Constraint parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.table.Constraint parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.table.Constraint parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static alluxio.grpc.table.Constraint parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static alluxio.grpc.table.Constraint parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static alluxio.grpc.table.Constraint parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static alluxio.grpc.table.Constraint parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static alluxio.grpc.table.Constraint parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(alluxio.grpc.table.Constraint prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code alluxio.grpc.table.Constraint}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:alluxio.grpc.table.Constraint)
      alluxio.grpc.table.ConstraintOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return alluxio.grpc.table.TableMasterProto.internal_static_alluxio_grpc_table_Constraint_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetColumnConstraints();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 1:
          return internalGetMutableColumnConstraints();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return alluxio.grpc.table.TableMasterProto.internal_static_alluxio_grpc_table_Constraint_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              alluxio.grpc.table.Constraint.class, alluxio.grpc.table.Constraint.Builder.class);
    }

    // Construct using alluxio.grpc.table.Constraint.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      internalGetMutableColumnConstraints().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return alluxio.grpc.table.TableMasterProto.internal_static_alluxio_grpc_table_Constraint_descriptor;
    }

    @java.lang.Override
    public alluxio.grpc.table.Constraint getDefaultInstanceForType() {
      return alluxio.grpc.table.Constraint.getDefaultInstance();
    }

    @java.lang.Override
    public alluxio.grpc.table.Constraint build() {
      alluxio.grpc.table.Constraint result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public alluxio.grpc.table.Constraint buildPartial() {
      alluxio.grpc.table.Constraint result = new alluxio.grpc.table.Constraint(this);
      int from_bitField0_ = bitField0_;
      result.columnConstraints_ = internalGetColumnConstraints();
      result.columnConstraints_.makeImmutable();
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof alluxio.grpc.table.Constraint) {
        return mergeFrom((alluxio.grpc.table.Constraint)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(alluxio.grpc.table.Constraint other) {
      if (other == alluxio.grpc.table.Constraint.getDefaultInstance()) return this;
      internalGetMutableColumnConstraints().mergeFrom(
          other.internalGetColumnConstraints());
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      alluxio.grpc.table.Constraint parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (alluxio.grpc.table.Constraint) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.MapField<
        java.lang.String, alluxio.grpc.table.Domain> columnConstraints_;
    private com.google.protobuf.MapField<java.lang.String, alluxio.grpc.table.Domain>
    internalGetColumnConstraints() {
      if (columnConstraints_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            ColumnConstraintsDefaultEntryHolder.defaultEntry);
      }
      return columnConstraints_;
    }
    private com.google.protobuf.MapField<java.lang.String, alluxio.grpc.table.Domain>
    internalGetMutableColumnConstraints() {
      onChanged();;
      if (columnConstraints_ == null) {
        columnConstraints_ = com.google.protobuf.MapField.newMapField(
            ColumnConstraintsDefaultEntryHolder.defaultEntry);
      }
      if (!columnConstraints_.isMutable()) {
        columnConstraints_ = columnConstraints_.copy();
      }
      return columnConstraints_;
    }

    public int getColumnConstraintsCount() {
      return internalGetColumnConstraints().getMap().size();
    }
    /**
     * <pre>
     * maps column to constraint, columns not present are not constrained
     * </pre>
     *
     * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
     */

    public boolean containsColumnConstraints(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetColumnConstraints().getMap().containsKey(key);
    }
    /**
     * Use {@link #getColumnConstraintsMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, alluxio.grpc.table.Domain> getColumnConstraints() {
      return getColumnConstraintsMap();
    }
    /**
     * <pre>
     * maps column to constraint, columns not present are not constrained
     * </pre>
     *
     * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
     */

    public java.util.Map<java.lang.String, alluxio.grpc.table.Domain> getColumnConstraintsMap() {
      return internalGetColumnConstraints().getMap();
    }
    /**
     * <pre>
     * maps column to constraint, columns not present are not constrained
     * </pre>
     *
     * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
     */

    public alluxio.grpc.table.Domain getColumnConstraintsOrDefault(
        java.lang.String key,
        alluxio.grpc.table.Domain defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, alluxio.grpc.table.Domain> map =
          internalGetColumnConstraints().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <pre>
     * maps column to constraint, columns not present are not constrained
     * </pre>
     *
     * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
     */

    public alluxio.grpc.table.Domain getColumnConstraintsOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, alluxio.grpc.table.Domain> map =
          internalGetColumnConstraints().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearColumnConstraints() {
      internalGetMutableColumnConstraints().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <pre>
     * maps column to constraint, columns not present are not constrained
     * </pre>
     *
     * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
     */

    public Builder removeColumnConstraints(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableColumnConstraints().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, alluxio.grpc.table.Domain>
    getMutableColumnConstraints() {
      return internalGetMutableColumnConstraints().getMutableMap();
    }
    /**
     * <pre>
     * maps column to constraint, columns not present are not constrained
     * </pre>
     *
     * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
     */
    public Builder putColumnConstraints(
        java.lang.String key,
        alluxio.grpc.table.Domain value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      if (value == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableColumnConstraints().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <pre>
     * maps column to constraint, columns not present are not constrained
     * </pre>
     *
     * <code>map&lt;string, .alluxio.grpc.table.Domain&gt; column_constraints = 1;</code>
     */

    public Builder putAllColumnConstraints(
        java.util.Map<java.lang.String, alluxio.grpc.table.Domain> values) {
      internalGetMutableColumnConstraints().getMutableMap()
          .putAll(values);
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:alluxio.grpc.table.Constraint)
  }

  // @@protoc_insertion_point(class_scope:alluxio.grpc.table.Constraint)
  private static final alluxio.grpc.table.Constraint DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new alluxio.grpc.table.Constraint();
  }

  public static alluxio.grpc.table.Constraint getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<Constraint>
      PARSER = new com.google.protobuf.AbstractParser<Constraint>() {
    @java.lang.Override
    public Constraint parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Constraint(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Constraint> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Constraint> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public alluxio.grpc.table.Constraint getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
