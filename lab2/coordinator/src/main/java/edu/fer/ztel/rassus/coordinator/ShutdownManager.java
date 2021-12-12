package edu.fer.ztel.rassus.coordinator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public record ShutdownManager(ApplicationContext applicationContext) {

  @Autowired
  public ShutdownManager {
  }

  public void shutdown() {
    SpringApplication.exit(applicationContext);
  }
}
