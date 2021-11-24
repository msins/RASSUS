package edu.fer.rassus.sensor.networking;

import edu.fer.rassus.sensor.model.Sensor;
import edu.fer.rassus.sensor.model.WeatherReading;
import edu.fer.rassus.sensor.networking.service.SensorService;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.adapter.rxjava3.Result;

public class SensorRepository {

  private final SensorService service = NetworkConfig.service;

  public Single<Result<Void>> registerSensor(Sensor sensor) {
    return service.registerSensor(sensor);
  }

  public Single<Result<Void>> unregisterSensor(int sensorId) {
    return service.unregisterSensor(sensorId);
  }

  public Observable<Result<Void>> sendReading(int sensorId, WeatherReading reading) {
    return service.sendReading(sensorId, reading)
        .toObservable();
  }

  public Observable<Result<Sensor>> findNearestSensor(int sensorId) {
    return service.findNearestSensor(sensorId)
        .toObservable();
  }
}
