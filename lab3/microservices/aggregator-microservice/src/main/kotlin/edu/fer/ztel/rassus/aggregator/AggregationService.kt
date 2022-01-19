package edu.fer.ztel.rassus.aggregator

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
@RefreshScope
class AggregationService(
    val temperatureRepository: TemperatureRepository,
    val humidityRepository: HumidityRepository
) {

    @Value("\${temperature.unit}")
    private lateinit var temperatureUnit: String

    fun getCurrentTemperature(): Mono<Temperature> {
        return temperatureRepository.getTemperature()
            .map { TemperatureConverter.forUnit(temperatureUnit).convert(it) }
    }

    fun getCurrentHumidity(): Mono<Humidity> {
        return humidityRepository.getHumidity()
    }
}