package edu.fer.ztel.rassus.humidity

import io.reactivex.rxjava3.core.Single
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class HumidityController(val humidityService: HumidityService) {

    @GetMapping("current")
    fun getCurrentHumidity(): Single<ResponseEntity<HumidityResponse>> {
        return humidityService.getCurrentHumidity()
            .map { HumidityMapper.localToRemote(it) }
            .map { ResponseEntity.ok(it) }
    }
}
