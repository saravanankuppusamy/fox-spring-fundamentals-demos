package com.foxinsurance.training.lesson3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(Lesson3Config.class)
@TestPropertySource(properties = "fox.support.email=classroom@fox.example")
class AnnotatedQuoteServiceIntegrationTest {
	@Autowired
	AnnotatedQuoteService service;

	@Test
	void springInjectsServiceAndTestProperty() {
		var result = service.quoteFor("Ava", 1000);
		assertTrue(result.contains("950.0"));
		assertTrue(result.contains("classroom@fox.example"));
	}
}
