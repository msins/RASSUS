package edu.fer.ztel.rassus.sensor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public record ShutdownManager(ApplicationContext applicationContext) {

  private static final Logger logger = LoggerFactory.getLogger(ShutdownManager.class);

  @Autowired
  public ShutdownManager {
  }

  public void shutdown() {
    logger.warn("Shutting down.");
    SpringApplication.exit(applicationContext);
  }
}
