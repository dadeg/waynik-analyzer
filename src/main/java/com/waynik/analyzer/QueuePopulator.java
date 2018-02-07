package com.waynik.analyzer;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class QueuePopulator extends TimerTask {
    private UserFactoryInterface userFactory;
    private Queue queue;

    public QueuePopulator(UserFactoryInterface userFactory, Queue queue) {
      this.userFactory = userFactory;
      this.queue = queue;

      Timer timer = new Timer();
      timer.scheduleAtFixedRate(this, 0, 5000);
    }

    private QueuePopulator() {
      // make it impossible to use default constructor?
    }

    /*
     * This is called from Timer, I hope.
     */
    public void run() {
        User user = userFactory.create();
        queue.add(user);
    }


}
