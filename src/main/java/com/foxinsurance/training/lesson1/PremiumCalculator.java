package com.foxinsurance.training.lesson1;

import com.foxinsurance.training.domain.QuoteRequest;

public interface PremiumCalculator {
	double calculate(QuoteRequest request);
}
