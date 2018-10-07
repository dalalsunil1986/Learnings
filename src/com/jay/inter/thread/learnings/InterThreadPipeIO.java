package com.jay.inter.thread.learnings;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import com.jay.piped.learnings.Consumer;
import com.jay.piped.learnings.Producer;

public class InterThreadPipeIO {
  public static void main(String[] args) throws IOException, InterruptedException {
    PipedOutputStream pipedOutputStream = new PipedOutputStream();
    PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
    Producer producer = new Producer(pipedOutputStream);
    Consumer consumer = new Consumer(pipedInputStream);
    Thread pThread = new Thread(producer);
    Thread cThread = new Thread(consumer);
    pThread.start();
    cThread.start();
    pThread.join();
    cThread.join();
    pipedOutputStream.close();
    pipedInputStream.close();
  }
}