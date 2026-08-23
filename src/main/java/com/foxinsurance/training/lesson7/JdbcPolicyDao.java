package com.foxinsurance.training.lesson7;

import com.foxinsurance.training.lesson6.*;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class JdbcPolicyDao implements PolicyDao {
	private final JdbcClient jdbc;

	public JdbcPolicyDao(JdbcClient jdbc) {
		this.jdbc = jdbc;
	}

	public long create(PolicyRecord p) {
		jdbc.sql(
				"INSERT INTO policies(customer_name, product_type, premium, status) VALUES (:customer,:type,:premium,:status)")
				.param("customer", p.customerName()).param("type", p.productType()).param("premium", p.premium())
				.param("status", p.status()).update();
		return jdbc.sql("SELECT MAX(id) FROM policies").query(Long.class).single();
	}

	public PolicyRecord findById(long id) {
		return jdbc.sql("SELECT id,customer_name,product_type,premium,status FROM policies WHERE id=:id")
				.param("id", id).query((rs, rowNum) -> new PolicyRecord(rs.getLong("id"), rs.getString("customer_name"),
						rs.getString("product_type"), rs.getDouble("premium"), rs.getString("status")))
				.single();
	}

	public List<PolicyRecord> findAll() {
		return jdbc.sql("SELECT id,customer_name,product_type,premium,status FROM policies ORDER BY id")
				.query((rs, rowNum) -> new PolicyRecord(rs.getLong("id"), rs.getString("customer_name"),
						rs.getString("product_type"), rs.getDouble("premium"), rs.getString("status")))
				.list();
	}

	public int updateStatus(long id, String status) {
		return jdbc.sql("UPDATE policies SET status=:status WHERE id=:id").param("status", status).param("id", id)
				.update();
	}
}
