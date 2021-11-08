package edu.fer.rassus.server.service

import edu.fer.rassus.server.model.WeatherReading
import edu.fer.rassus.server.repository.SensorRepository
import edu.fer.rassus.server.repository.WeatherReadingRepository
import io.reactivex.Single
import org.springframework.stereotype.Service
import javax.transaction.Transactional

// for easier 204 handling
class NoSensorException : RuntimeException()

@Service
class WeatherReadingService(
    private val weatherReadingRepository: WeatherReadingRepository,
    private val sensorRepository: SensorRepository
) {
    @Transactional
    fun addWeatherReading(id: Int, reading: WeatherReading): Single<WeatherReading> {
        return Single.create { subscriber ->
            val sensorOptional = sensorRepository.findById(id)
            if (sensorOptional.isEmpty) {
                subscriber.onError(NoSensorException())
                return@create
            }

            val sensor = sensorOptional.get()
            sensor.addWeatherReading(reading)
            sensorRepository.save(sensor)
            subscriber.onSuccess(sensor.readings.last())
        }
    }

    @Transactional
    fun getWeatherReading(sensorId: Int, readingId: Int): Single<WeatherReading> {
        return Single.create { subscriber ->
            val sensorOptional = sensorRepository.findById(sensorId)
            if (sensorOptional.isEmpty) {
                subscriber.onError(IllegalArgumentException("No sensor with id: $sensorId"))
                return@create
            }

            val readingOptional = weatherReadingRepository.findById(readingId)
            if (readingOptional.isEmpty) {
                subscriber.onError(IllegalArgumentException("No weather reading with id $readingId"))
                return@create
            }

            subscriber.onSuccess(readingOptional.get())
        }
    }

    @Transactional
    fun getAllForSensor(sensorId: Int): Single<List<WeatherReading>> {
        return Single.create { subscriber ->
            val sensorOptional = sensorRepository.findById(sensorId)
            if (sensorOptional.isEmpty) {
                subscriber.onError(NoSensorException())
                return@create
            }

            val sensor = sensorOptional.get()
            subscriber.onSuccess(sensor.readings)
        }
    }
}