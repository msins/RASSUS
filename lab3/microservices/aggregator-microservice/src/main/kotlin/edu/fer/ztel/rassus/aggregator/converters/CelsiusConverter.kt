package edu.fer.ztel.rassus.aggregator.converters

import edu.fer.ztel.rassus.aggregator.Temperature
import edu.fer.ztel.rassus.aggregator.TemperatureConverter

class CelsiusConverter : TemperatureConverter {
    override fun convert(temperature: Temperature): Temperature {
        return when (temperature.unit) {
            "C" -> temperature
            "K" -> temperature.apply {
                unit = "C"
                value += 273.15
            }
            else -> throw IllegalArgumentException("Unknown temperature unit: ${temperature.unit}")
        }
    }
}