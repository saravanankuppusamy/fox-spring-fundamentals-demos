package com.foxinsurance.training.lesson1;

import com.foxinsurance.training.domain.*;

public class QuoteService {

	private final PremiumCalculator calculator;

	public QuoteService(PremiumCalculator calculator) {
		this.calculator = calculator;
	}

	public Quote createQuote(QuoteRequest request) {
		return new Quote(request.customerName(), request.type(), request.coverageAmount(),
				calculator.calculate(request));
	}
}
