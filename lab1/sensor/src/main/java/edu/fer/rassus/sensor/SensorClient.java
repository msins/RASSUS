package edu.fer.rassus.sensor;

import edu.fer.rassus.sensor.SensorServiceGrpc.SensorServiceBlockingStub;
import edu.fer.rassus.sensor.model.Sensor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensorClient {

  private static final Logger logger = LoggerFactory.getLogger(SensorClient.class);

  private final ManagedChannel channel;
  private final SensorServiceBlockingStub blockingStub;

  public SensorClient(String host, int port) {
    channel = ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext()
        .build();

    blockingStub = SensorServiceGrpc.newBlockingStub(channel);
  }


  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  public ReadingResponse fetchReadingFrom(Sensor sensor) {
    SensorRequest request = SensorRequest.newBuilder()
        .setIp(sensor.getIp())
        .setPort(sensor.getPort())
        .setLatitude(sensor.getLatitude())
        .setLongitude(sensor.getLongitude())
        .build();

    logger.info("\nSending:\n" + request);
    return blockingStub.requestReading(request);
  }
}
