package edu.fer.ztel.rassus.temperature

data class TemperatureResponse(
    val name: String,
    val value: Double,
    val unit: String
) {
}