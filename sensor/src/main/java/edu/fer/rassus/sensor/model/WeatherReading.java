package edu.fer.rassus.sensor.model;

import edu.fer.rassus.sensor.ReadingResponse;
import java.util.Arrays;

public class WeatherReading {

  double temperature;
  double pressure;
  double humidity;
  double co;
  double no2;
  double so2;

  public WeatherReading(double temperature, double pressure, double humidity, double co, double no2, double so2) {
    this.temperature = temperature;
    this.pressure = pressure;
    this.humidity = humidity;
    this.co = co;
    this.no2 = no2;
    this.so2 = so2;
  }

  public static WeatherReading parse(String line) {
    String[] parts = line.split(",", -1);
    int temperature = Integer.parseInt(parts[0]);
    int pressure = Integer.parseInt(parts[1]);
    int humidity = Integer.parseInt(parts[2]);
    int co = Integer.parseInt(parts[3]);
    int no2 = parts[4].isEmpty() ? 0 : Integer.parseInt(parts[4]);
    int so2 = parts[5].isEmpty() ? 0 : Integer.parseInt(parts[5]);
    return new WeatherReading(temperature, pressure, humidity, co, no2, so2);
  }

  public static WeatherReading from(ReadingResponse readingResponse) {
    return new WeatherReading(
        readingResponse.getTemperature(),
        readingResponse.getPressure(),
        readingResponse.getHumidity(),
        readingResponse.getCo(),
        readingResponse.getNo2(),
        readingResponse.getSo2()
    );
  }

  public double getTemperature() {
    return temperature;
  }

  public double getPressure() {
    return pressure;
  }

  public double getHumidity() {
    return humidity;
  }

  public double getCo() {
    return co;
  }

  public double getNo2() {
    return no2;
  }

  public double getSo2() {
    return so2;
  }

  @Override
  public String toString() {
    return "WeatherReading{" +
        "temperature=" + temperature +
        ", pressure=" + pressure +
        ", humidity=" + humidity +
        ", co=" + co +
        ", no2=" + no2 +
        ", so2=" + so2 +
        '}';
  }
}
