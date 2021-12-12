package edu.fer.ztel.rassus.coordinator.config;

import java.util.HashMap;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaAdminConfiguration {

  @Bean
  public KafkaAdmin kafkaAdmin() {
    var config = new HashMap<String, Object>();
    config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    return new KafkaAdmin(config);
  }

  @Bean
  public NewTopic registerTopic() {
    return new NewTopic("Register", 1, (short) 1);
  }

  @Bean
  public NewTopic commandTopic() {
    return new NewTopic("Command", 1, (short) 1);
  }
}
