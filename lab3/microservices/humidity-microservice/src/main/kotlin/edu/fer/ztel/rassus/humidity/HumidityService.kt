package edu.fer.ztel.rassus.humidity

import io.reactivex.rxjava3.core.Single
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class HumidityService(
    val humidityRepository: HumidityRepository,
    val humidityGenerator: HumidityGenerator
) {

    fun getCurrentHumidity(): Single<Humidity> {
        return Single.create {
            val currentHumidity = humidityGenerator.random()
            currentHumidity.time = LocalDateTime.now()
            it.onSuccess(humidityRepository.saveAndFlush(currentHumidity))
        }
    }
}