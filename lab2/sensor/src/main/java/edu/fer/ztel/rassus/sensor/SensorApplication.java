package edu.fer.ztel.rassus.sensor;

import edu.fer.ztel.rassus.sensor.sensor.Sensor;
import java.util.Collections;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SensorApplication {


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("> Enter sensor id: ");
    int id = in.nextInt();
    System.out.print("> Enter sensor port: ");
    int port = in.nextInt();

    Sensor.instance = new Sensor(id, "127.0.0.1", port);
    System.out.println(Sensor.instance);

    var app = new SpringApplication(SensorApplication.class);
    app.setDefaultProperties(Collections.singletonMap("server.port", String.valueOf(port)));
    app.setDefaultProperties(Collections.singletonMap("kafka.sensor.group.id", String.valueOf(id)));
    app.run(args);
  }
}
