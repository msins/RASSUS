package edu.fer.rassus.sensor.utils;

import edu.fer.rassus.sensor.model.WeatherReading;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public final class WeatherReadingGenerator {

  private static final List<WeatherReading> readings;
  private static final long startInSeconds = System.currentTimeMillis() / 1000;

  static {
    var loader = Thread.currentThread().getContextClassLoader();
    var reader = new BufferedReader(new InputStreamReader(loader.getResourceAsStream("resources.csv")));
    readings = reader.lines().skip(1).map(WeatherReading::parse).collect(Collectors.toList());
  }

  private WeatherReadingGenerator() {
  }

  public static WeatherReading random() {
    return readings.get(randomRow());
  }

  private static int randomRow() {
    return (int) (activeSecondsCount() % 100);
  }


  private static long activeSecondsCount() {
    return (System.currentTimeMillis() / 1000) - startInSeconds;
  }

}
