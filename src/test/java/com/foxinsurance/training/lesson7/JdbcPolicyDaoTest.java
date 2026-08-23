package com.foxinsurance.training.lesson7;

import com.foxinsurance.training.lesson6.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(Lesson7Config.class)
@Sql("classpath:reset-schema.sql")
@Transactional
class JdbcPolicyDaoTest {
	@Autowired
	PolicyDao dao;

	@Test
	void jdbcClientCrud() {
		long id = dao.create(new PolicyRecord(null, "Mia", "HOME", 980, "ACTIVE"));
		assertEquals("Mia", dao.findById(id).customerName());
		assertEquals(1, dao.updateStatus(id, "RENEWAL_DUE"));
	}
}
