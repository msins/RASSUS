package edu.fer.rassus.server.repository

import edu.fer.rassus.server.model.Sensor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SensorRepository : JpaRepository<Sensor, Int> {
}