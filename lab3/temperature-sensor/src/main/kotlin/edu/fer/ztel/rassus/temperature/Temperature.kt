package edu.fer.ztel.rassus.temperature

import org.hibernate.annotations.NaturalId
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Temperature(
    @Column
    var value: Double,

    @Column
    var unit: String,

    @Column
    @NaturalId
    var time: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null
)