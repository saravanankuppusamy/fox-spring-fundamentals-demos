package com.foxinsurance.training.lesson3;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
	public String findTier(String name) {
		return name.startsWith("A") ? "GOLD" : "STANDARD";
	}
}
