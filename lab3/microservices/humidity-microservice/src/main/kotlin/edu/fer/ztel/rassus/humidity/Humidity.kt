package edu.fer.ztel.rassus.humidity

import org.hibernate.annotations.NaturalId
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Humidity(

    // value is a reserved keyword
    @Column(name = "humidity_value")
    var value: Int,

    @Column
    var unit: String,

    @Column
    var time: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null
)