package edu.fer.ztel.rassus.coordinator;

import edu.fer.ztel.rassus.coordinator.command.CommandProducer;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {

  private final CommandProducer commandProducer;
  private final ShutdownManager shutdownManager;

  @Autowired
  public CommandRunner(CommandProducer commandProducer, ShutdownManager shutdownManager) {
    this.commandProducer = commandProducer;
    this.shutdownManager = shutdownManager;
  }

  @Override
  public void run(String... args) throws Exception {
    Scanner in = new Scanner(System.in);

    while (true) {
      // todo: show input prompt after initialization without sleeping
      Thread.sleep(500);

      System.out.print("> Enter command: ");
      var command = in.nextLine();

      if (command.equalsIgnoreCase("exit")) {
        System.out.println("Exiting...");
        shutdownManager.shutdown();
        break;
      }

      commandProducer.sendCommand(command);
    }
  }
}
