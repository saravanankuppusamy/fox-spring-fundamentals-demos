package com.foxinsurance.training.domain;

public record QuoteRequest(String customerName, InsuranceType type, double coverageAmount, boolean safeDriver) {
}
