package edu.fer.ztel.rassus.aggregator

import io.reactivex.rxjava3.core.Single
import org.springframework.stereotype.Repository
import retrofit2.http.GET

@Repository
interface AggregationRepository {

    @GET
    fun getTemperature(): Single<TemperatureResponse>

    @GET
    fun getHumidity(): Single<HumidityResponse>
}