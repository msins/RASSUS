package edu.fer.ztel.rassus.aggregator

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.core.env.Environment
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.function.BiFunction

@RestController
@RequestMapping
@RefreshScope
class AggregationController(val aggregationService: AggregationService, val env: Environment) {

    @Value("\${temperature.unit}")
    private lateinit var temperatureUnit: String

    @GetMapping("current", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getCurrentTemperatureAndHumidity(): Mono<ResponseEntity<AggregationResponse>> {
        return Mono.zip(
            aggregationService.getCurrentTemperature(TemperatureConverter.forUnit(temperatureUnit)),
            aggregationService.getCurrentHumidity(),
            BiFunction { temperature, humidity -> AggregationResponse(temperature, humidity) }
        ).map { ResponseEntity.ok(it) }
    }

    @GetMapping("test-config")
    fun getConfig(): String {
        return env.getProperty("temperature.unit", "cloud config not working")
    }
}