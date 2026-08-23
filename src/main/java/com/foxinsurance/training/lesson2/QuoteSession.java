package com.foxinsurance.training.lesson2;

import java.util.UUID;

public class QuoteSession {
	private final String id = UUID.randomUUID().toString();

	public String id() {
		return id;
	}
}
