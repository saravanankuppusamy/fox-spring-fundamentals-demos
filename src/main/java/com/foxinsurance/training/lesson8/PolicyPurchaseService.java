package com.foxinsurance.training.lesson8;

import com.foxinsurance.training.lesson6.*;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service
public class PolicyPurchaseService {
	private final PolicyDao dao;
	private final JdbcClient jdbc;

	public PolicyPurchaseService(PolicyDao dao, JdbcClient jdbc) {
		this.dao = dao;
		this.jdbc = jdbc;
	}

	@Transactional
	public long purchase(String customer, String product, double premium, boolean simulateFailure) {
		long id = dao.create(new PolicyRecord(null, customer, product, premium, "ACTIVE"));
		jdbc.sql("INSERT INTO policy_audit(policy_id,action) VALUES (:id,:action)").param("id", id)
				.param("action", "POLICY_PURCHASED").update();
		if (simulateFailure)
			throw new IllegalStateException("Simulated payment failure - transaction should roll back");
		return id;
	}

	@Transactional(readOnly = true)
	public int policyCount() {
		return jdbc.sql("SELECT COUNT(*) FROM policies").query(Integer.class).single();
	}
}
