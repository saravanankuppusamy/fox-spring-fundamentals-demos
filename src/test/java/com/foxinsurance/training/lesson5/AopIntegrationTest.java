package com.foxinsurance.training.lesson5;

import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(Lesson5Config.class)
class AopIntegrationTest {
	@Autowired
	PolicyIssuanceService service;

	@Test
	void serviceIsProxied() {
		assertTrue(AopUtils.isAopProxy(service));
		assertTrue(service.issuePolicy("Noah", "auto").startsWith("FOX-AUTO"));
	}
}
