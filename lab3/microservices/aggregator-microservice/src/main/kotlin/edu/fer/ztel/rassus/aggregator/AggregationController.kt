package edu.fer.ztel.rassus.aggregator

import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.function.BiFunction

@RestController
@RequestMapping
class AggregationController(val aggregationService: AggregationService, val env: Environment) {

    @GetMapping("current")
    fun getCurrentTemperatureAndHumidity(): Mono<ResponseEntity<AggregationResponse>> {
        return Mono.zip(
            aggregationService.getCurrentTemperature(),
            aggregationService.getCurrentHumidity(),
            BiFunction { temperature, humidity -> AggregationResponse(temperature, humidity) }
        ).map { ResponseEntity.ok(it) }
    }

    @GetMapping("test-config")
    fun getConfig(): String {
        return env.getProperty("temperature.unit", "cloud config not working")
    }
}