package com.foxinsurance.training.lesson2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:fox.properties")
public class Lesson2Config {
	@Bean(name = { "companyName", "insurerName" })
	String companyName(@Value("${fox.company.name}") String value) {
		return value;
	}

	@Bean
	@Profile("email")
	NotificationChannel emailNotificationChannel() {
		return new EmailNotificationChannel();
	}

	@Bean
	@Profile("sms")
	NotificationChannel smsNotificationChannel() {
		return new SmsNotificationChannel();
	}

	@Bean
	@Profile("default")
	NotificationChannel defaultNotificationChannel() {
		return new EmailNotificationChannel();
	}

	@Bean
	@Scope("prototype")
	QuoteSession quoteSession() {
		return new QuoteSession();
	}

	@Bean
	@Lazy
	ExpensiveRiskModel expensiveRiskModel() {
		return new ExpensiveRiskModel();
	}
}
