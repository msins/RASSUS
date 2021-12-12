package edu.fer.ztel.rassus.coordinator.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public record CommandProducer(KafkaTemplate<String, String> kafkaTemplate) {

  private static final String TOPIC = "Command";

  @Autowired
  public CommandProducer {
  }

  public void sendCommand(String command) {
    kafkaTemplate.send(TOPIC, command);
  }
}
