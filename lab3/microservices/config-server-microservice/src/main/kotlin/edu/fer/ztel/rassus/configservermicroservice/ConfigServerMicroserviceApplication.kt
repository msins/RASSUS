package edu.fer.ztel.rassus.configservermicroservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class ConfigServerMicroserviceApplication

fun main(args: Array<String>) {
	runApplication<ConfigServerMicroserviceApplication>(*args)
}
