package edu.fer.ztel.rassus.humidity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HumidityRepository : JpaRepository<Humidity, Long> {
}