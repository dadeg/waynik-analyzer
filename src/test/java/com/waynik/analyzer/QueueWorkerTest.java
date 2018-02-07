package com.waynik.analyzer;
import static org.junit.Assert.assertEquals;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.waynik.analyzer.senders.AlertSenderInterface;
import com.waynik.analyzer.senders.SysOutAlertSender;

public class QueueWorkerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void workerGrabsItemFromQueue() {
		Queue<UserInterface> userQueue = new ConcurrentLinkedQueue<UserInterface>();
		QueueWorker<UserInterface> worker = new QueueWorker<UserInterface>(userQueue, new SysOutAlertSender());
		UserFactoryInterface userFactory = new UserFactoryFake();
		User user = userFactory.create();
		userQueue.add(user);
		assertEquals(userQueue.size(), 1);
		worker.run();
		assertEquals(userQueue.size(), 0);
	}

	@Test
	public void workerIdentifiesAlert() {
		int assertCounter = 0;
		Queue<UserInterface> userQueue = new ConcurrentLinkedQueue<UserInterface>();
		AlertSenderInterface alertSender = new AlertSenderInterface() {
			public void send(String string) {
				assertCounter++;
			}
		};
		
		QueueWorker<UserInterface> worker = new QueueWorker<UserInterface>(userQueue, alertSender);
		UserFactoryInterface userFactory = new UserFactoryFake();
		User user = userFactory.create();
		userQueue.add(user);
		worker.run();
		assertEquals(assertCounter, 1);
	}

}
