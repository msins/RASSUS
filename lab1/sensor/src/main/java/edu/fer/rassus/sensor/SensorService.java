package edu.fer.rassus.sensor;

import edu.fer.rassus.sensor.model.WeatherReading;
import io.grpc.stub.StreamObserver;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensorService extends SensorServiceGrpc.SensorServiceImplBase {

  private static final Logger logger = LoggerFactory.getLogger(SensorService.class);
  private final Supplier<WeatherReading> serverReading;

  public SensorService(Supplier<WeatherReading> serverReading) {
    this.serverReading = serverReading;
  }

  @Override
  public void requestReading(SensorRequest sensor, StreamObserver<ReadingResponse> responseObserver) {
    logger.info("Got request from sensor:\n" + sensor);

    ReadingResponse myReading = newGRPCReading(serverReading.get());
    responseObserver.onNext(myReading);

    logger.info("Responding with reading:\n" + myReading);
    responseObserver.onCompleted();
  }

  private static ReadingResponse newGRPCReading(WeatherReading reading) {
    return ReadingResponse.newBuilder()
        .setTemperature(reading.getTemperature())
        .setHumidity(reading.getHumidity())
        .setPressure(reading.getPressure())
        .setCo(reading.getCo())
        .setNo2(reading.getNo2())
        .setSo2(reading.getSo2())
        .build();
  }
}
