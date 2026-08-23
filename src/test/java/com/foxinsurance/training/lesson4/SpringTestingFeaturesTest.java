package com.foxinsurance.training.lesson4;

import com.foxinsurance.training.lesson2.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(Lesson2Config.class)
@ActiveProfiles("email")
class SpringTestingFeaturesTest {
	@Autowired
	NotificationChannel channel;

	@Test
	void activeProfileControlsBeans() {
		assertTrue(channel instanceof EmailNotificationChannel);
	}

	@Test
	@DirtiesContext
	void dirtyContextExample() {
		assertTrue(channel.send("test").startsWith("EMAIL"));
	}
}
