package edu.fer.ztel.rassus.aggregator

import io.reactivex.rxjava3.core.Single
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("aggregation")
class AggregationController(val aggregationService: AggregationService) {

    @GetMapping("current")
    fun getCurrentTemperatureAndHumidity(): Single<ResponseEntity<AggregationResponse>> {
        return aggregationService.getCurrentTemperatureAndHumidity()
            .map { ResponseEntity.ok(it) }
    }

}