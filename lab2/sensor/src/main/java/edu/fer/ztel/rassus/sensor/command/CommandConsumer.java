package edu.fer.ztel.rassus.sensor.command;

import edu.fer.ztel.rassus.sensor.registration.RegistrationProducer;
import edu.fer.ztel.rassus.sensor.ShutdownManager;
import edu.fer.ztel.rassus.sensor.sensor.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CommandConsumer {

  private static final Logger logger = LoggerFactory.getLogger(CommandConsumer.class);

  private final RegistrationProducer registrationProducer;
  private final ShutdownManager shutdownManager;

  @Autowired
  public CommandConsumer(RegistrationProducer registrationProducer, ShutdownManager shutdownManager) {
    this.registrationProducer = registrationProducer;
    this.shutdownManager = shutdownManager;
  }

  @KafkaListener(topics = "Command", groupId = "${kafka.sensor.group.id}")
  public void onCommand(String command) {
    logger.info("Got command: " + command);
    switch (command) {
      case "Start" -> registrationProducer.register(Sensor.instance);
      case "Stop" -> shutdownManager.shutdown();
      default -> logger.warn("Unsupported command: " + command);
    }
  }
}
