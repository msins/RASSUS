package edu.fer.ztel.rassus.aggregator

import edu.fer.ztel.rassus.aggregator.converters.CelsiusConverter
import edu.fer.ztel.rassus.aggregator.converters.KelvinConverter

interface TemperatureConverter {
    companion object {
        fun forUnit(unit: String): TemperatureConverter {
            return when (unit) {
                "celsius" -> CelsiusConverter()
                "kelvin" -> KelvinConverter()
                else -> throw IllegalArgumentException("Unknown temperature unit: $unit")
            }
        }
    }

    fun convert(temperature: Temperature): Temperature
}