package com.foxinsurance.training.lesson5;

import org.springframework.stereotype.Service;

@Service
public class PolicyIssuanceServiceImpl implements PolicyIssuanceService {
	public String issuePolicy(String customer, String product) {
		if (customer == null || customer.isBlank())
			throw new IllegalArgumentException("customer is required");
		return "FOX-" + product.toUpperCase() + "-" + Math.abs(customer.hashCode());
	}
}
