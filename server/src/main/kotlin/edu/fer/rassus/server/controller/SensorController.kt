package edu.fer.rassus.server.controller

import edu.fer.rassus.server.AddSensorRequest
import edu.fer.rassus.server.dto.SensorWithoutIdResponse
import edu.fer.rassus.server.model.Sensor
import edu.fer.rassus.server.model.WeatherReading
import edu.fer.rassus.server.service.SensorService
import edu.fer.rassus.server.service.WeatherReadingService
import io.reactivex.Single
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("api/v1/sensor")
class SensorController(
    private val sensorService: SensorService,
    private val weatherReadingService: WeatherReadingService
) {
    @PostMapping
    fun registerSensor(
        @RequestBody body: AddSensorRequest,
        request: HttpServletRequest
    ): Single<ResponseEntity<URI>> {
        println("Register sensor: $body")
        return sensorService.addSensor(body)
            .map {
                ResponseEntity.created(
                    URI(request.requestURI.plus("/${it.id}"))
                ).build()
            }
    }

    @DeleteMapping("{sensorId}")
    fun unregisterSensor(@PathVariable sensorId: Int): Single<ResponseEntity<Unit>> {
        println("Unregister sensor: $sensorId")
        return sensorService.deleteSensor(sensorId)
            .map { if (it) ResponseEntity.ok().build() else ResponseEntity.badRequest().build() }
    }

    @PostMapping("{sensorId}")
    fun addWeatherReading(
        @PathVariable sensorId: Int,
        @RequestBody reading: WeatherReading,
        request: HttpServletRequest
    ): Single<ResponseEntity<URI>> {
        return weatherReadingService.addWeatherReading(sensorId, reading)
            .map {
                ResponseEntity.created(
                    URI(request.servletPath.plus("/${it.id}"))
                ).build()
            }
    }

    @GetMapping("nearest/{id}")
    fun getNearestNeighbour(@PathVariable id: Int): Single<ResponseEntity<SensorWithoutIdResponse>> {
        return sensorService.findClosestTo(id)
            .map { ResponseEntity.ok(SensorWithoutIdResponse.from(it)) }
    }

    @GetMapping
    fun getSensors(): Single<ResponseEntity<List<Sensor>>> {
        return sensorService.getAll()
            .map { ResponseEntity.ok(it) }
    }
}