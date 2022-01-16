package edu.fer.ztel.rassus.temperature

object TemperatureMapper {

    fun csvToLocal(csvString: String): Temperature {
        val reading = csvString.split(",")
        val valueInCelsius = reading[0].toDouble()
        return Temperature(valueInCelsius, "C")
    }

    fun localToRemote(temperature: Temperature): TemperatureResponse {
        return TemperatureResponse(
            name = "Temperature",
            value = temperature.value,
            unit = temperature.unit
        )
    }
}