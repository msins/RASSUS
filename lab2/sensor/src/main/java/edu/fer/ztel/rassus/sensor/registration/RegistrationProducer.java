package edu.fer.ztel.rassus.sensor.registration;

import edu.fer.ztel.rassus.sensor.sensor.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public record RegistrationProducer(KafkaTemplate<String, Sensor> kafkaTemplate) {

  private static final String TOPIC = "Register";

  @Autowired
  public RegistrationProducer {
  }

  public void register(Sensor sensor) {
    kafkaTemplate.send(TOPIC, sensor);
  }
}