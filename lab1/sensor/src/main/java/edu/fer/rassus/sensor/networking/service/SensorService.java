package edu.fer.rassus.sensor.networking.service;

import edu.fer.rassus.sensor.model.Sensor;
import edu.fer.rassus.sensor.model.WeatherReading;
import io.reactivex.rxjava3.core.Single;
import retrofit2.adapter.rxjava3.Result;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SensorService {

  @GET("sensor/nearest/{id}")
  Single<Result<Sensor>> findNearestSensor(@Path("id") int sensorId);

  @POST("sensor")
  Single<Result<Void>> registerSensor(@Body Sensor sensor);

  @POST("sensor/{id}")
  Single<Result<Void>> sendReading(
      @Path("id") int sensorId,
      @Body WeatherReading reading
  );

  @DELETE("sensor/{id}")
  Single<Result<Void>> unregisterSensor(@Path("id") int sensorId);
}
