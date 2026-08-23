package com.foxinsurance.training.lesson2;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;


class BeanConfigurationTest {
	@Test
	void prototypeReturnsDifferentInstances() {
		try (var c = new AnnotationConfigApplicationContext(Lesson2Config.class)) {
			assertNotSame(c.getBean(QuoteSession.class), c.getBean(QuoteSession.class));
		}
	}

	@Test
	void profileSelectsSms() {
		var c = new AnnotationConfigApplicationContext();
		c.getEnvironment().setActiveProfiles("sms");
		c.register(Lesson2Config.class);
		c.refresh();
		assertTrue(c.getBean(NotificationChannel.class) instanceof SmsNotificationChannel);
		c.close();
	}
}
