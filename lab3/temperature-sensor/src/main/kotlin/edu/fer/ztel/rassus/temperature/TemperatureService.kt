package edu.fer.ztel.rassus.temperature

import io.reactivex.rxjava3.core.Single
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TemperatureService(
    val temperatureRepository: TemperatureRepository,
    val temperatureGenerator: TemperatureGenerator
) {

    fun getCurrentTemperature(): Single<Temperature> {
        return Single.create {
            val currentTemperature = temperatureGenerator.random()
            currentTemperature.time = LocalDateTime.now()
            it.onSuccess(temperatureRepository.save(currentTemperature))
        }
    }
}