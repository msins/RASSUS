package edu.fer.ztel.rassus.aggregator.networking

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class NetworkConfig {

    @Bean
    @LoadBalanced
    fun provideWebClientBuilder(): WebClient.Builder {
        return WebClient.builder()
    }

}
