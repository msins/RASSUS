package edu.fer.ztel.rassus.coordinator.registration;

import edu.fer.ztel.rassus.coordinator.sensor.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RegistrationConsumer {

  private static final Logger logger = LoggerFactory.getLogger(RegistrationConsumer.class);

  @KafkaListener(topics = "Register", containerFactory = "registrationKafkaListenerContainerFactory")
  public void listenRegistration(Sensor sensor) {
    logger.info("Registered: " + sensor);
  }
}
