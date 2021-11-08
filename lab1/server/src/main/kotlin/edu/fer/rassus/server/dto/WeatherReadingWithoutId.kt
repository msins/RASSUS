package edu.fer.rassus.server.dto

import edu.fer.rassus.server.model.WeatherReading

class WeatherReadingWithoutId private constructor(
    val temperature: Double,
    val pressure: Double,
    val humidity: Double,
    val co: Double,
    val so2: Double,
    val no2: Double
) {

    companion object {
        fun from(reading: WeatherReading): WeatherReadingWithoutId {
            return WeatherReadingWithoutId(
                reading.temperature,
                reading.pressure,
                reading.humidity,
                reading.co,
                reading.so2,
                reading.no2
            )
        }
    }

}