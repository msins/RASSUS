package edu.fer.ztel.rassus.humidity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.EnableMBeanExport

@SpringBootApplication
@EnableEurekaClient
class HumidityApplication

fun main(args: Array<String>) {
    runApplication<HumidityApplication>(*args)
}
