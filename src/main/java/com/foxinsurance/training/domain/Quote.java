package com.foxinsurance.training.domain;

public record Quote(String customerName, InsuranceType type, double coverageAmount, double annualPremium) {
}
