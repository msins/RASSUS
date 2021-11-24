package edu.fer.rassus.sensor.model;

public class Sensor {

  private final double latitude;
  private final double longitude;
  private final String ip;
  private final int port;

  public Sensor(double latitude, double longitude, String ip, int port) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.ip = ip;
    this.port = port;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public String getIp() {
    return ip;
  }

  public int getPort() {
    return port;
  }

  @Override
  public String toString() {
    return "Sensor{" +
        "lat=" + latitude +
        ", lon=" + longitude +
        ", ip='" + ip + '\'' +
        ", port=" + port +
        '}';
  }
}
