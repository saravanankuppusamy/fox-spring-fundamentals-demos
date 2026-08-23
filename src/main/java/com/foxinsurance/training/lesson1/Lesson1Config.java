package com.foxinsurance.training.lesson1;

import org.springframework.context.annotation.*;

@Configuration
public class Lesson1Config {

	@Bean
	PremiumCalculator premiumCalculator() {
		return new StandardPremiumCalculator();
	}

	@Bean
	QuoteService quoteService(PremiumCalculator calculator) {
		return new QuoteService(calculator);
	}
}
