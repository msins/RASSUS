package edu.fer.rassus.server.repository

import edu.fer.rassus.server.model.WeatherReading
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WeatherReadingRepository : JpaRepository<WeatherReading, Int> {
}