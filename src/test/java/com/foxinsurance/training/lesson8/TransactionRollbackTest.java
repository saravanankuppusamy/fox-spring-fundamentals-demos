package com.foxinsurance.training.lesson8;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(Lesson8Config.class)
@Sql("classpath:reset-schema.sql")
class TransactionRollbackTest {
	@Autowired
	PolicyPurchaseService service;

	@Test
	void runtimeExceptionRollsBackWholeUnitOfWork() {
		int before = service.policyCount();
		assertThrows(IllegalStateException.class, () -> service.purchase("Emma", "AUTO", 1400, true));
		assertEquals(before, service.policyCount());
	}
}
