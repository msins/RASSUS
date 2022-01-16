package edu.fer.ztel.rassus.aggregator

import org.springframework.cloud.square.retrofit.core.RetrofitClient
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import retrofit2.http.GET

@Repository
@RetrofitClient("humidity-microservice")
interface HumidityRepository {

    @GET("current")
    fun getHumidity(): Mono<Humidity>
}