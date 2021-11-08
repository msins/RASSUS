package edu.fer.rassus.server.controller

import edu.fer.rassus.server.dto.WeatherReadingWithoutId
import edu.fer.rassus.server.model.WeatherReading
import edu.fer.rassus.server.service.WeatherReadingService
import io.reactivex.Single
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/weather")
class WeatherReadingController(private val weatherReadingService: WeatherReadingService) {

    @GetMapping("{sensorId}/{readingId}")
    fun getReading(
        @PathVariable sensorId: Int,
        @PathVariable readingId: Int
    ): Single<ResponseEntity<WeatherReadingWithoutId>> {
        return weatherReadingService.getWeatherReading(sensorId, readingId)
            .map { ResponseEntity.ok(WeatherReadingWithoutId.from(it)) }
    }

    @GetMapping("{sensorId}")
    fun getReadingForSensor(
        @PathVariable sensorId: Int
    ): Single<ResponseEntity<List<WeatherReading>>> {
        return weatherReadingService.getAllForSensor(sensorId)
            .map { ResponseEntity.ok(it) }
    }
}