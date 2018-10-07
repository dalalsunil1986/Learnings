package com.jay.piped.learnings;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer implements Runnable {

  private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

  private final PipedInputStream pipedInputStream;

  public Consumer(PipedInputStream pipedInputStream) {
    this.pipedInputStream = pipedInputStream;
  }

  @Override
  public void run() {
    try {
      while (true) {
        int value = pipedInputStream.read();
        logger.info("Consumer thread consuming: {}", value);
        Thread.sleep(50);
        if (value == 25)
          break;
      }
    } catch (IOException | InterruptedException e) {
      StringWriter sw = new StringWriter();
      e.printStackTrace(new PrintWriter(sw));
      logger.error(sw.toString());
    } finally {
      try {
        pipedInputStream.close();
      } catch (IOException e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        logger.error(sw.toString());
      }
    }
  }
}