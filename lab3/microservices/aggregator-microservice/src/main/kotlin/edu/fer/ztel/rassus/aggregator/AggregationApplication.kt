package edu.fer.ztel.rassus.aggregator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.square.retrofit.webclient.EnableRetrofitClients

@SpringBootApplication
@EnableEurekaClient
@EnableRetrofitClients
class AggregationApplication

fun main(args: Array<String>) {
    runApplication<AggregationApplication>(*args)
}
