package iroha.protocol;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: endpoint.proto")
public final class CommandServiceGrpc {

  private CommandServiceGrpc() {}

  public static final String SERVICE_NAME = "iroha.protocol.CommandService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getToriiMethod()} instead. 
  public static final io.grpc.MethodDescriptor<iroha.protocol.BlockOuterClass.Transaction,
      com.google.protobuf.Empty> METHOD_TORII = getToriiMethodHelper();

  private static volatile io.grpc.MethodDescriptor<iroha.protocol.BlockOuterClass.Transaction,
      com.google.protobuf.Empty> getToriiMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<iroha.protocol.BlockOuterClass.Transaction,
      com.google.protobuf.Empty> getToriiMethod() {
    return getToriiMethodHelper();
  }

  private static io.grpc.MethodDescriptor<iroha.protocol.BlockOuterClass.Transaction,
      com.google.protobuf.Empty> getToriiMethodHelper() {
    io.grpc.MethodDescriptor<iroha.protocol.BlockOuterClass.Transaction, com.google.protobuf.Empty> getToriiMethod;
    if ((getToriiMethod = CommandServiceGrpc.getToriiMethod) == null) {
      synchronized (CommandServiceGrpc.class) {
        if ((getToriiMethod = CommandServiceGrpc.getToriiMethod) == null) {
          CommandServiceGrpc.getToriiMethod = getToriiMethod = 
              io.grpc.MethodDescriptor.<iroha.protocol.BlockOuterClass.Transaction, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iroha.protocol.CommandService", "Torii"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iroha.protocol.BlockOuterClass.Transaction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new CommandServiceMethodDescriptorSupplier("Torii"))
                  .build();
          }
        }
     }
     return getToriiMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStatusMethod()} instead. 
  public static final io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest,
      iroha.protocol.Endpoint.ToriiResponse> METHOD_STATUS = getStatusMethodHelper();

  private static volatile io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest,
      iroha.protocol.Endpoint.ToriiResponse> getStatusMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest,
      iroha.protocol.Endpoint.ToriiResponse> getStatusMethod() {
    return getStatusMethodHelper();
  }

  private static io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest,
      iroha.protocol.Endpoint.ToriiResponse> getStatusMethodHelper() {
    io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest, iroha.protocol.Endpoint.ToriiResponse> getStatusMethod;
    if ((getStatusMethod = CommandServiceGrpc.getStatusMethod) == null) {
      synchronized (CommandServiceGrpc.class) {
        if ((getStatusMethod = CommandServiceGrpc.getStatusMethod) == null) {
          CommandServiceGrpc.getStatusMethod = getStatusMethod = 
              io.grpc.MethodDescriptor.<iroha.protocol.Endpoint.TxStatusRequest, iroha.protocol.Endpoint.ToriiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "iroha.protocol.CommandService", "Status"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iroha.protocol.Endpoint.TxStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iroha.protocol.Endpoint.ToriiResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CommandServiceMethodDescriptorSupplier("Status"))
                  .build();
          }
        }
     }
     return getStatusMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStatusStreamMethod()} instead. 
  public static final io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest,
      iroha.protocol.Endpoint.ToriiResponse> METHOD_STATUS_STREAM = getStatusStreamMethodHelper();

  private static volatile io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest,
      iroha.protocol.Endpoint.ToriiResponse> getStatusStreamMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest,
      iroha.protocol.Endpoint.ToriiResponse> getStatusStreamMethod() {
    return getStatusStreamMethodHelper();
  }

  private static io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest,
      iroha.protocol.Endpoint.ToriiResponse> getStatusStreamMethodHelper() {
    io.grpc.MethodDescriptor<iroha.protocol.Endpoint.TxStatusRequest, iroha.protocol.Endpoint.ToriiResponse> getStatusStreamMethod;
    if ((getStatusStreamMethod = CommandServiceGrpc.getStatusStreamMethod) == null) {
      synchronized (CommandServiceGrpc.class) {
        if ((getStatusStreamMethod = CommandServiceGrpc.getStatusStreamMethod) == null) {
          CommandServiceGrpc.getStatusStreamMethod = getStatusStreamMethod = 
              io.grpc.MethodDescriptor.<iroha.protocol.Endpoint.TxStatusRequest, iroha.protocol.Endpoint.ToriiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "iroha.protocol.CommandService", "StatusStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iroha.protocol.Endpoint.TxStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iroha.protocol.Endpoint.ToriiResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CommandServiceMethodDescriptorSupplier("StatusStream"))
                  .build();
          }
        }
     }
     return getStatusStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommandServiceStub newStub(io.grpc.Channel channel) {
    return new CommandServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommandServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommandServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommandServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommandServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CommandServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void torii(iroha.protocol.BlockOuterClass.Transaction request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getToriiMethodHelper(), responseObserver);
    }

    /**
     */
    public void status(iroha.protocol.Endpoint.TxStatusRequest request,
        io.grpc.stub.StreamObserver<iroha.protocol.Endpoint.ToriiResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStatusMethodHelper(), responseObserver);
    }

    /**
     */
    public void statusStream(iroha.protocol.Endpoint.TxStatusRequest request,
        io.grpc.stub.StreamObserver<iroha.protocol.Endpoint.ToriiResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStatusStreamMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getToriiMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                iroha.protocol.BlockOuterClass.Transaction,
                com.google.protobuf.Empty>(
                  this, METHODID_TORII)))
          .addMethod(
            getStatusMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                iroha.protocol.Endpoint.TxStatusRequest,
                iroha.protocol.Endpoint.ToriiResponse>(
                  this, METHODID_STATUS)))
          .addMethod(
            getStatusStreamMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                iroha.protocol.Endpoint.TxStatusRequest,
                iroha.protocol.Endpoint.ToriiResponse>(
                  this, METHODID_STATUS_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class CommandServiceStub extends io.grpc.stub.AbstractStub<CommandServiceStub> {
    private CommandServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommandServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommandServiceStub(channel, callOptions);
    }

    /**
     */
    public void torii(iroha.protocol.BlockOuterClass.Transaction request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getToriiMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void status(iroha.protocol.Endpoint.TxStatusRequest request,
        io.grpc.stub.StreamObserver<iroha.protocol.Endpoint.ToriiResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStatusMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void statusStream(iroha.protocol.Endpoint.TxStatusRequest request,
        io.grpc.stub.StreamObserver<iroha.protocol.Endpoint.ToriiResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStatusStreamMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommandServiceBlockingStub extends io.grpc.stub.AbstractStub<CommandServiceBlockingStub> {
    private CommandServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommandServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommandServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty torii(iroha.protocol.BlockOuterClass.Transaction request) {
      return blockingUnaryCall(
          getChannel(), getToriiMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public iroha.protocol.Endpoint.ToriiResponse status(iroha.protocol.Endpoint.TxStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getStatusMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<iroha.protocol.Endpoint.ToriiResponse> statusStream(
        iroha.protocol.Endpoint.TxStatusRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStatusStreamMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommandServiceFutureStub extends io.grpc.stub.AbstractStub<CommandServiceFutureStub> {
    private CommandServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommandServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommandServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> torii(
        iroha.protocol.BlockOuterClass.Transaction request) {
      return futureUnaryCall(
          getChannel().newCall(getToriiMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<iroha.protocol.Endpoint.ToriiResponse> status(
        iroha.protocol.Endpoint.TxStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStatusMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TORII = 0;
  private static final int METHODID_STATUS = 1;
  private static final int METHODID_STATUS_STREAM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommandServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommandServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TORII:
          serviceImpl.torii((iroha.protocol.BlockOuterClass.Transaction) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_STATUS:
          serviceImpl.status((iroha.protocol.Endpoint.TxStatusRequest) request,
              (io.grpc.stub.StreamObserver<iroha.protocol.Endpoint.ToriiResponse>) responseObserver);
          break;
        case METHODID_STATUS_STREAM:
          serviceImpl.statusStream((iroha.protocol.Endpoint.TxStatusRequest) request,
              (io.grpc.stub.StreamObserver<iroha.protocol.Endpoint.ToriiResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CommandServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommandServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return iroha.protocol.Endpoint.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommandService");
    }
  }

  private static final class CommandServiceFileDescriptorSupplier
      extends CommandServiceBaseDescriptorSupplier {
    CommandServiceFileDescriptorSupplier() {}
  }

  private static final class CommandServiceMethodDescriptorSupplier
      extends CommandServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommandServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommandServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommandServiceFileDescriptorSupplier())
              .addMethod(getToriiMethodHelper())
              .addMethod(getStatusMethodHelper())
              .addMethod(getStatusStreamMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
