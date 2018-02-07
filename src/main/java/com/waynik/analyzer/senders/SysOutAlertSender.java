package com.waynik.analyzer.senders;

public class SysOutAlertSender implements AlertSenderInterface {

	@Override
	public void send(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}

}
