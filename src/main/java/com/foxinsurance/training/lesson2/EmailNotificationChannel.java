package com.foxinsurance.training.lesson2;

public class EmailNotificationChannel implements NotificationChannel {
	public EmailNotificationChannel() {
		System.out.println("Constructing EmailNotificationChannel");
	}

	public String send(String message) {
		return "EMAIL -> " + message;
	}
}
