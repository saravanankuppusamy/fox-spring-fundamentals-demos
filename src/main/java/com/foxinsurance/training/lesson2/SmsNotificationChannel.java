package com.foxinsurance.training.lesson2;

public class SmsNotificationChannel implements NotificationChannel {
	public SmsNotificationChannel() {
		System.out.println("Constructing SmsNotificationChannel");
	}

	public String send(String message) {
		return "SMS -> " + message;
	}
}
