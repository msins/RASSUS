package edu.fer.ztel.rassus.humidity

import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.util.stream.Collectors

@Component
class HumidityGenerator {

    private lateinit var readings: List<Humidity>
    private val startInSeconds = System.currentTimeMillis() / 1000;

    fun random(): Humidity {
        return readings[randomRow()]
    }

    private fun randomRow(): Int {
        return (activeSecondsCount() % 100).toInt()
    }

    private fun activeSecondsCount(): Long {
        return (System.currentTimeMillis() / 1000) - startInSeconds
    }

    init {
        val loader = Thread.currentThread().contextClassLoader
        val readingsInputStream = loader.getResourceAsStream("readings.csv")
        if (readingsInputStream == null) {
            throw FileNotFoundException("Missing readings.csv")
        }

        val reader = BufferedReader(InputStreamReader(readingsInputStream))
        readings = reader.lines()
            .skip(1)
            .map(HumidityMapper::csvToLocal)
            .collect(Collectors.toList())
    }
}