package com.waynik.analyzer;
import java.util.Queue;

import com.waynik.analyzer.senders.AlertSenderInterface;

public class QueueWorker<E extends UserInterface> implements Runnable {
    private String name;
    private Queue<E> queue;
    private AlertSenderInterface alertSender;

    public QueueWorker(Queue<E> queue, AlertSenderInterface alertSender) {
      this.queue = queue;
      this.alertSender = alertSender;
    }

    private QueueWorker() {
      // make it impossible to use default constructor?
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
    	System.out.println("starting to work");
      while (true) {
        E itemToAnalyze = getNextItem();
        if (itemToAnalyze != null) {
        	// get the checkins
        	
        	// analyze the checkins with all the analyzers
        	
        	// send alert if an alert is returned
            alertSender.send(name + " analyzed user " + itemToAnalyze.getEmail());
        }
      }
    }
    
    private E getNextItem() {
    	return queue.poll();
    }
}
