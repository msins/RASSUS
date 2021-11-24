package edu.fer.rassus.server.dto

import edu.fer.rassus.server.model.Sensor

data class AddSensorRequest(
    val latitude: Double,
    val longitude: Double,
    val ip: String,
    val port: Int
)

fun AddSensorRequest.toEntity(): Sensor {
    return Sensor(
        latitude = this.latitude,
        longitude = this.longitude,
        ip = this.ip,
        port = this.port,
    )
}