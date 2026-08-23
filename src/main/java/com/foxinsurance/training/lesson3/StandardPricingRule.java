package com.foxinsurance.training.lesson3;

import org.springframework.stereotype.Component;

@Component("standardPricing")
public class StandardPricingRule implements PricingRule {
	public double apply(double basePremium) {
		return basePremium;
	}
}
