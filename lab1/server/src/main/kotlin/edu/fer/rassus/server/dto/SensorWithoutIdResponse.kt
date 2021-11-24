package edu.fer.rassus.server.dto

import edu.fer.rassus.server.model.Sensor

class SensorWithoutIdResponse private constructor(
    val latitude: Double,
    val longitude: Double,
    val ip: String,
    val port: Int
) {
    companion object {
        fun from(sensor: Sensor): SensorWithoutIdResponse {
            return SensorWithoutIdResponse(sensor.latitude, sensor.longitude, sensor.ip, sensor.port)
        }
    }
}