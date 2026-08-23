package com.foxinsurance.training.lesson3;

import jakarta.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class AnnotatedQuoteService {
	private final CustomerRepository repository;
	private final PricingRule pricingRule;
	private String supportEmail;

	public AnnotatedQuoteService(CustomerRepository repository, @Qualifier("loyaltyPricing") PricingRule pricingRule) {
		this.repository = repository;
		this.pricingRule = pricingRule;
	}

	@Autowired
	public void setSupportEmail(@Value("${fox.support.email}") String supportEmail) {
		this.supportEmail = supportEmail;
	}

	@PostConstruct
	public void started() {
		System.out.println("@PostConstruct: AnnotatedQuoteService ready");
	}

	@PreDestroy
	public void stopping() {
		System.out.println("@PreDestroy: AnnotatedQuoteService stopping");
	}

	public String quoteFor(String customer, double basePremium) {
		return customer + " tier=" + repository.findTier(customer) + ", premium=" + pricingRule.apply(basePremium)
				+ ", help=" + supportEmail;
	}
}
