package edu.fer.rassus.sensor;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.41.0)",
    comments = "Source: sensor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SensorServiceGrpc {

  private SensorServiceGrpc() {}

  public static final String SERVICE_NAME = "edu.fer.rassus.sensor.SensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.fer.rassus.sensor.SensorRequest,
      edu.fer.rassus.sensor.ReadingResponse> getRequestReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestReading",
      requestType = edu.fer.rassus.sensor.SensorRequest.class,
      responseType = edu.fer.rassus.sensor.ReadingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.fer.rassus.sensor.SensorRequest,
      edu.fer.rassus.sensor.ReadingResponse> getRequestReadingMethod() {
    io.grpc.MethodDescriptor<edu.fer.rassus.sensor.SensorRequest, edu.fer.rassus.sensor.ReadingResponse> getRequestReadingMethod;
    if ((getRequestReadingMethod = SensorServiceGrpc.getRequestReadingMethod) == null) {
      synchronized (SensorServiceGrpc.class) {
        if ((getRequestReadingMethod = SensorServiceGrpc.getRequestReadingMethod) == null) {
          SensorServiceGrpc.getRequestReadingMethod = getRequestReadingMethod =
              io.grpc.MethodDescriptor.<edu.fer.rassus.sensor.SensorRequest, edu.fer.rassus.sensor.ReadingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.fer.rassus.sensor.SensorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.fer.rassus.sensor.ReadingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SensorServiceMethodDescriptorSupplier("RequestReading"))
              .build();
        }
      }
    }
    return getRequestReadingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorServiceStub>() {
        @java.lang.Override
        public SensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorServiceStub(channel, callOptions);
        }
      };
    return SensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorServiceBlockingStub>() {
        @java.lang.Override
        public SensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorServiceBlockingStub(channel, callOptions);
        }
      };
    return SensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SensorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SensorServiceFutureStub>() {
        @java.lang.Override
        public SensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SensorServiceFutureStub(channel, callOptions);
        }
      };
    return SensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SensorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void requestReading(edu.fer.rassus.sensor.SensorRequest request,
        io.grpc.stub.StreamObserver<edu.fer.rassus.sensor.ReadingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestReadingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestReadingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.fer.rassus.sensor.SensorRequest,
                edu.fer.rassus.sensor.ReadingResponse>(
                  this, METHODID_REQUEST_READING)))
          .build();
    }
  }

  /**
   */
  public static final class SensorServiceStub extends io.grpc.stub.AbstractAsyncStub<SensorServiceStub> {
    private SensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorServiceStub(channel, callOptions);
    }

    /**
     */
    public void requestReading(edu.fer.rassus.sensor.SensorRequest request,
        io.grpc.stub.StreamObserver<edu.fer.rassus.sensor.ReadingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestReadingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SensorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SensorServiceBlockingStub> {
    private SensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.fer.rassus.sensor.ReadingResponse requestReading(edu.fer.rassus.sensor.SensorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestReadingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SensorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SensorServiceFutureStub> {
    private SensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SensorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.fer.rassus.sensor.ReadingResponse> requestReading(
        edu.fer.rassus.sensor.SensorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestReadingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST_READING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SensorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SensorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_READING:
          serviceImpl.requestReading((edu.fer.rassus.sensor.SensorRequest) request,
              (io.grpc.stub.StreamObserver<edu.fer.rassus.sensor.ReadingResponse>) responseObserver);
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

  private static abstract class SensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.fer.rassus.sensor.Sensor.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SensorService");
    }
  }

  private static final class SensorServiceFileDescriptorSupplier
      extends SensorServiceBaseDescriptorSupplier {
    SensorServiceFileDescriptorSupplier() {}
  }

  private static final class SensorServiceMethodDescriptorSupplier
      extends SensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SensorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SensorServiceFileDescriptorSupplier())
              .addMethod(getRequestReadingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
