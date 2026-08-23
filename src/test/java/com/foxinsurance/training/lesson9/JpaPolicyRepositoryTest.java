package com.foxinsurance.training.lesson9;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(Lesson9Config.class)
class JpaPolicyRepositoryTest {
	@Autowired
	JpaPolicyRepository repo;

	@Test
	void entityLifecycleAndDirtyChecking() {
		var p = repo.save(new PolicyEntity("Sophia", "TRAVEL", 450, "ACTIVE"));
		assertNotNull(p.getId());
		repo.changeStatus(p.getId(), "CLAIM_OPEN");
		assertEquals("CLAIM_OPEN", repo.find(p.getId()).getStatus());
	}
}
