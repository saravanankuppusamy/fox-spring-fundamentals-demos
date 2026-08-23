package com.foxinsurance.training.lesson1;

import com.foxinsurance.training.domain.*;

public class StandardPremiumCalculator implements PremiumCalculator {
	public double calculate(QuoteRequest r) {
		double rate = switch (r.type()) {
		case AUTO -> .035;
		case HOME -> .012;
		case TRAVEL -> .018;
		case HEALTH -> .055;
		};
		double premium = r.coverageAmount() * rate;
		return r.safeDriver() && r.type() == InsuranceType.AUTO ? premium * .90 : premium;
	}
}
