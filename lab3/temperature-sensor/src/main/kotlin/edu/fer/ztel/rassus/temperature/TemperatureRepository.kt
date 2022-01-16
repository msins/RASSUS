package edu.fer.ztel.rassus.temperature

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TemperatureRepository : JpaRepository<Temperature, Long> {
}