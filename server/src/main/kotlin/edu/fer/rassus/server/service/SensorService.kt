package edu.fer.rassus.server.service

import edu.fer.rassus.server.AddSensorRequest
import edu.fer.rassus.server.model.Sensor
import edu.fer.rassus.server.repository.SensorRepository
import edu.fer.rassus.server.toEntity
import io.reactivex.Single
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class SensorService(private val sensorRepository: SensorRepository) {

    @Transactional
    fun addSensor(body: AddSensorRequest): Single<Sensor> {
        return Single.create {
            val sensor = body.toEntity()
            it.onSuccess(sensorRepository.save(sensor))
        }
    }

    @Transactional
    fun findClosestTo(sensorId: Int): Single<Sensor> {
        return Single.create { subscriber ->
            val sensorOptional = sensorRepository.findById(sensorId)
            if (sensorOptional.isEmpty) {
                subscriber.onError(IllegalArgumentException("No sensor with id $sensorId"))
                return@create
            }

            val sensor = sensorOptional.get()
            val closesNeighbour = sensorRepository.findAll()
                .filter { it != sensor }
                .minByOrNull { sensor.distanceTo(it) }

            if (closesNeighbour == null) {
                subscriber.onError(IllegalArgumentException("No neighbours."))
                return@create
            }

            subscriber.onSuccess(closesNeighbour)
        }
    }

    @Transactional
    fun getAll(): Single<List<Sensor>> {
        return Single.create { it.onSuccess(sensorRepository.findAll()) }
    }

    @Transactional
    fun deleteSensor(sensorId: Int): Single<Boolean> {
        return Single.create {
            try {
                sensorRepository.deleteById(sensorId)
            } catch (e: Exception) {
                it.onSuccess(false)
                return@create
            }

            it.onSuccess(true)
        }
    }
}