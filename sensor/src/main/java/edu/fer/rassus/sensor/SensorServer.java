package edu.fer.rassus.sensor;

import edu.fer.rassus.sensor.model.Sensor;
import edu.fer.rassus.sensor.model.WeatherReading;
import edu.fer.rassus.sensor.networking.SensorRepository;
import edu.fer.rassus.sensor.utils.SensorGenerator;
import edu.fer.rassus.sensor.utils.WeatherReadingGenerator;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SensorServer {

  private static final Logger logger = LoggerFactory.getLogger(SensorServer.class);

  private final CompositeDisposable disposable = new CompositeDisposable();
  private final SensorRepository repository = new SensorRepository();
  private final Server server;

  private final Sensor sensor;
  private WeatherReading currentReading = WeatherReadingGenerator.random();
  private int sensorId;

  public SensorServer(Sensor sensor) {
    this.server = ServerBuilder.forPort(sensor.getPort())
        .addService(new SensorService(() -> currentReading))
        .build();
    this.sensor = sensor;
  }

  public void start() throws IOException {
    server.start();

    setupShutdownProcedure();

    var registrationResult = repository.registerSensor(sensor)
        .blockingGet();

    if (registrationResult.isError()) {
      throw new RuntimeException(registrationResult.error());
    }

    var response = registrationResult.response();
    if (response == null) {
      throw new RuntimeException("Server not returning response.");
    }

    String location = response.headers().get("Location");
    if (location == null) {
      throw new RuntimeException("Location header not set.");
    }

    String lastSegment = location.substring(location.lastIndexOf("/") + 1);
    sensorId = Integer.parseInt(lastSegment);

    disposable.add(Observable.interval(3, TimeUnit.SECONDS)
        .map(i -> WeatherReadingGenerator.random())
        .flatMap(reading -> repository.sendReading(sensorId, reading))
        .flatMap(result -> {
          if (result.isError()) {
            return Observable.error(new RuntimeException("Failed to send reading to server."));
          }

          return repository.findNearestSensor(sensorId);
        })
        .flatMap(result -> {
          if (result == null || result.response() == null) {
            return Observable.error(new RuntimeException("Server failed to return the nearest sensor."));
          }

          Sensor nearestSensor = result.response().body();

          if (nearestSensor == null) {
            return Observable.error(
                new IllegalStateException("Can't find other sensor. Add more sensors to the network."));
          }

          logger.info("Nearest sensor is: " + nearestSensor);

          SensorClient client = new SensorClient(nearestSensor.getIp(), nearestSensor.getPort());
          ReadingResponse readingResponse = client.fetchReadingFrom(nearestSensor);

          //todo
          try {
            client.shutdown();
          } catch (InterruptedException ignored) {
          }

          var nearestSensorWeatherReading = WeatherReading.from(readingResponse);
          currentReading = calibrate(currentReading, nearestSensorWeatherReading);

          return repository.sendReading(sensorId, currentReading);
        })
        .retryWhen(errors -> errors.flatMap(error -> {
          // retry if there aren't any sensors in network
          if (error instanceof IllegalStateException) {
            logger.info(error.getMessage());
            return Observable.just(0);
          }

          return Observable.error(error);
        }))
        .subscribe(result -> {
        }, error -> logger.error(error.getMessage()))
    );
  }

  private WeatherReading calibrate(WeatherReading first, WeatherReading second) {
    return new WeatherReading(
        (first.getTemperature() + second.getTemperature()) / 2,
        (first.getPressure() + second.getPressure()) / 2,
        (first.getHumidity() + second.getHumidity()) / 2,
        (first.getCo() + second.getCo()) / 2,
        (first.getSo2() + second.getSo2()) / 2,
        (first.getNo2() + second.getNo2()) / 2
    );
  }

  private void setupShutdownProcedure() {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      logger.info("Shutting down sensor with id: " + sensorId);

      var result = repository.unregisterSensor(sensorId)
          .blockingGet();

      if (!result.isError()) {
        logger.info("Successfully unregistered sensor with id: " + sensorId);
      } else {
        logger.warn("Unsuccessfully unregistered sensor with id: " + sensorId);
      }

      try {
        SensorServer.this.stop();
      } catch (InterruptedException e) {
        e.printStackTrace(System.err);
      }
      logger.info("Sensor with id: " + sensorId + " has shut down.");
    }));
  }

  private void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }
  }

  public void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  public static void main(String[] args) throws InterruptedException, IOException {
    Sensor sensor = SensorGenerator.newSensor();
    SensorServer server = new SensorServer(sensor);
    server.start();
    server.blockUntilShutdown();
  }
}
