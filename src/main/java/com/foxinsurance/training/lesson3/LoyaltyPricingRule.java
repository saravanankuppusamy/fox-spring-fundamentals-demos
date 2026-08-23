package com.foxinsurance.training.lesson3;

import org.springframework.stereotype.Component;

@Component("loyaltyPricing")
public class LoyaltyPricingRule implements PricingRule {
	public double apply(double basePremium) {
		return basePremium * .95;
	}
}
