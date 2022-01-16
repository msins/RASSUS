package edu.fer.ztel.rassus.humidity

object HumidityMapper {

    fun csvToLocal(csvString: String): Humidity {
        val reading = csvString.split(",")
        val valueInPercentage = reading[2].toInt()
        return Humidity(valueInPercentage, "%")
    }

    fun localToRemote(humidity: Humidity): HumidityResponse {
        return HumidityResponse(
            name = "Humidity",
            unit = humidity.unit,
            value = humidity.value
        )
    }
}