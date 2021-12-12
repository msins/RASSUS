package edu.fer.ztel.rassus.coordinator.sensor;

public record Sensor(int id, String address, int port) {

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Sensor sensor = (Sensor) o;

    return id == sensor.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
