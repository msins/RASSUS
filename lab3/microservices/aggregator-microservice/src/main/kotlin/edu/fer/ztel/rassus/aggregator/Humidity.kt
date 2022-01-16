package edu.fer.ztel.rassus.aggregator

import com.fasterxml.jackson.annotation.JsonProperty

data class Humidity(
    @JsonProperty("name") var name: String,
    @JsonProperty("unit") var unit: String,
    @JsonProperty("value") var value: Int
)