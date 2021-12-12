package edu.fer.ztel.rassus.sensor.sensor;

import java.util.StringJoiner;

public record Sensor(int id, String address, int port) {

  /**
   * Represents this sensor, initialized at startup.
   */
  public transient static Sensor instance;

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

  @Override
  public String toString() {
    return new StringJoiner(", ", Sensor.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("address='" + address + "'")
        .add("port=" + port)
        .toString();
  }
}
