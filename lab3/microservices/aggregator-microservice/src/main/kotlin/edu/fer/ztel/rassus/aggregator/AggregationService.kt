package edu.fer.ztel.rassus.aggregator

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AggregationService(
    val temperatureRepository: TemperatureRepository,
    val humidityRepository: HumidityRepository
) {

    fun getCurrentTemperature(converter: TemperatureConverter): Mono<Temperature> {
        return temperatureRepository.getTemperature().map { converter.convert(it) }
    }

    fun getCurrentHumidity(): Mono<Humidity> {
        return humidityRepository.getHumidity()
    }

//    fun getCurrentTemperatureAndHumidity(): Mono<AggregationResponse> {
//        return Mono.zip(
//            temperatureRepository.getTemperature(),
//            humidityRepository.getHumidity(),
//            { temperature, humidity -> AggregationResponse(temperature, humidity) }
//        )
//    }
}