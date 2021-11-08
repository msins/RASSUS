package edu.fer.rassus.sensor.networking;

import edu.fer.rassus.sensor.networking.service.SensorService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkConfig {

  private NetworkConfig() {
  }

  public static final SensorService service = createService();

  private static OkHttpClient provideOkHttpClient() {
    return new OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build();
  }

  private static Retrofit provideRetrofit() {
    return new Retrofit.Builder()
        .baseUrl(Api.BASE_URL)
        .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build();
  }

  private static SensorService createService() {
    return provideRetrofit().create(SensorService.class);
  }
}
