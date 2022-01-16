package edu.fer.ztel.rassus.aggregator

import io.reactivex.rxjava3.core.Single
import org.springframework.stereotype.Service

@Service
class AggregationService(val aggregationRepository: AggregationRepository) {

    //todo converter celsius to kelvin

    fun getCurrentTemperatureAndHumidity(): Single<AggregationResponse> {
        return Single.zip(
            aggregationRepository.getTemperature(),
            aggregationRepository.getHumidity(),
            { temperature, humidity -> AggregationResponse(temperature, humidity) }
        )
    }
}