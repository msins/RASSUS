package edu.fer.ztel.rassus.aggregator

data class AggregationResponse(
    val temperature: TemperatureResponse,
    val humidity: HumidityResponse
)