package com.foxinsurance.training.lesson6;

import java.util.List;

public interface PolicyDao {
	long create(PolicyRecord policy);

	PolicyRecord findById(long id);

	List<PolicyRecord> findAll();

	int updateStatus(long id, String status);
}
