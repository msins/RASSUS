package edu.fer.ztel.rassus.coordinator;

import edu.fer.ztel.rassus.coordinator.command.CommandProducer;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoordinatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(CoordinatorApplication.class, args);
  }
}
