package edu.fer.rassus.server.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class WeatherReading(
    @Column
    val temperature: Double,

    @Column
    val pressure: Double,

    @Column
    val humidity: Double,

    @Column
    val co: Double,

    @Column
    val no2: Double,

    @Column
    val so2: Double,

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    var sensor: Sensor? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null
) {
    override fun toString(): String {
        return "WeatherReading( " +
                "temperature = $temperature," +
                "pressure = $pressure," +
                "humidity = $humidity," +
                "co = $co," +
                "so2 = $so2," +
                "no2 = $no2," +
                "sensor = $sensor," +
                "id = $id)"
    }
}