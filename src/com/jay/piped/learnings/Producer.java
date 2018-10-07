package com.jay.piped.learnings;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer implements Runnable {

  private static final Logger logger = LoggerFactory.getLogger(Producer.class);

  private final PipedOutputStream pipedOutputStream;

  public Producer(PipedOutputStream pipedOutputStream) {
    this.pipedOutputStream = pipedOutputStream;
  }

  @Override
  public void run() {
    int index = 0;
    try {
      while (index <= 25) {
        logger.info("Producer thread generating: {}", index);
        pipedOutputStream.write(index);
        Thread.sleep(50);
        index++;
      }
    } catch (IOException | InterruptedException e) {
      StringWriter sw = new StringWriter();
      e.printStackTrace(new PrintWriter(sw));
      logger.error(sw.toString());
    } finally {
      try {
        pipedOutputStream.close();
      } catch (IOException e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        logger.error(sw.toString());
      }
    }
  }
}
