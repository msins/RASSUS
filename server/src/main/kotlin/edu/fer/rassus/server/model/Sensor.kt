package edu.fer.rassus.server.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import kotlin.math.*

typealias Degree = Double
typealias Radian = Double

fun Degree.toRadian(): Radian = this / 180 * Math.PI

@Entity
class Sensor(
    @Column
    val latitude: Degree,

    @Column
    val longitude: Degree,

    @Column
    val ip: String,

    @Column
    val port: Int,

    @JsonIgnore
    @OneToMany(mappedBy = "sensor", cascade = [CascadeType.ALL], orphanRemoval = true)
    val readings: MutableList<WeatherReading> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null
) {
    init {
        require(latitude in -90.0..90.0) { " Latitude has to be in [-90, 90] range." }
        require(longitude in -90.0..90.0) { " Longitude has to be in [-90, 90] range." }
    }

    fun addWeatherReading(reading: WeatherReading) {
        this.readings.add(reading)
        reading.sensor = this
    }

    fun distanceTo(other: Sensor): Double {
        val r = 6371
        val dLongitude = (other.longitude - this.longitude).toRadian()
        val dLatitude = (other.latitude - this.latitude).toRadian()
        val a = sin(dLatitude / 2).pow(2) + cos(this.latitude) * cos(other.latitude) * sin(dLongitude / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return r * c
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Sensor

        if (latitude != other.latitude) return false
        if (longitude != other.longitude) return false
        if (ip != other.ip) return false
        if (port != other.port) return false

        return true
    }

    override fun hashCode(): Int {
        var result = latitude.hashCode()
        result = 31 * result + longitude.hashCode()
        result = 31 * result + ip.hashCode()
        result = 31 * result + port
        return result
    }

    override fun toString(): String {
        return "Sensor(" +
                "latitude=$latitude," +
                "longitude=$longitude," +
                "ip='$ip'," +
                "port=$port," +
                "readings=$readings," +
                "id=$id)"
    }
}