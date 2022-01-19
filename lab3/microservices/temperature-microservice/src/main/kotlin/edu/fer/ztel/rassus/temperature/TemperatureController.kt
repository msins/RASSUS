package edu.fer.ztel.rassus.temperature

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.ResponseEntity
import io.reactivex.rxjava3.core.Single
import org.springframework.http.MediaType

@RestController
@RequestMapping
class TemperatureController(val temperatureService: TemperatureService) {

    @GetMapping("current")
    fun getCurrentTemperature(): Single<ResponseEntity<TemperatureResponse>> {
        return temperatureService.getCurrentTemperature()
            .map { TemperatureMapper.localToRemote(it) }
            .map { ResponseEntity.ok(it) }
    }
}