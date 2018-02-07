package com.waynik.analyzer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.waynik.analyzer.senders.EmailAlertSender;


public class CheckinQueue {
    public static void main(String[] args) {
        Queue<UserInterface> userQueue = new ConcurrentLinkedQueue<UserInterface>();

        UserFactoryInterface userFactory = new UserFactoryFake();

        new QueuePopulator(userFactory, userQueue);

        QueueWorker<UserInterface> workerOne = new QueueWorker<UserInterface>(userQueue, new EmailAlertSender());
        QueueWorker<UserInterface> workerTwo = new QueueWorker<UserInterface>(userQueue, new EmailAlertSender());

        Thread[] threads = {
        	new Thread(workerOne),
        	new Thread(workerTwo)
        };
        
        for (Thread workerThread : threads) {
        	workerThread.start();
        }
        
        workerOne.setName("worker 1");
        workerTwo.setName("worker 2");
    }
}
