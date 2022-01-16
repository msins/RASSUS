package edu.fer.ztel.rassus.aggregator.converters

import edu.fer.ztel.rassus.aggregator.Temperature
import edu.fer.ztel.rassus.aggregator.TemperatureConverter

class KelvinConverter : TemperatureConverter {

    override fun convert(temperature: Temperature): Temperature {
        return when (temperature.unit) {
            "K" -> temperature
            "C" -> temperature.apply {
                unit = "K"
                value -= 273.15
            }
            else -> throw IllegalArgumentException("Unknown temperature unit: ${temperature.unit}")
        }
    }
}