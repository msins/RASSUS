package edu.fer.ztel.rassus.humidity

import org.springframework.stereotype.Component

@Component
class HumidityGenerator private constructor() {

    private lateinit var readings: List<Humidity>
    private val startInSeconds = System.currentTimeMillis() / 1000;

    fun random(): Humidity {
        readings.get()
    }

    private fun randomRow(): Int {
        return (activeSecondsCount() % 100).toInt()
    }

    private fun activeSecondsCount(): Long {
        return (System.currentTimeMillis() / 1000) - startInSeconds
    }

    companion object {

        init {

        }
    }
}