package edu.fer.ztel.rassus.temperature

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class TemperatureSensorApplication

fun main(args: Array<String>) {
    runApplication<TemperatureSensorApplication>(*args)
}
