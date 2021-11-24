package edu.fer.rassus.sensor.utils;

import edu.fer.rassus.sensor.model.Sensor;

public final class SensorGenerator {

  private SensorGenerator() {
  }

  public static Sensor newSensor() {
    return new Sensor(
        randomLatitude(),
        randomLongitude(),
        "127.0.0.1",
        randomPort()
    );
  }

  private static int randomPort() {
    return (int) (Math.random() * 1000 + 3000);
  }

  private static double randomLongitude() {
    return Math.random() * (16 - 15.87) + 15.87;
  }

  private static double randomLatitude() {
    return Math.random() * (45.85 - 45.75) + 45.75;
  }
}
