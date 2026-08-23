package com.foxinsurance.training.lesson1;

import com.foxinsurance.training.domain.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson1App {
	public static void main(String[] args) {
		// Spring is the object factory/container. Business classes remain POJOs.
		try (var context = new AnnotationConfigApplicationContext(Lesson1Config.class)) {
			var service = context.getBean(QuoteService.class);
			var quote = service.createQuote(new QuoteRequest("Ava", InsuranceType.AUTO, 50_000, true));
			System.out.println("Created quote: " + quote);
			System.out.println("Bean names: " + String.join(", ", context.getBeanDefinitionNames()));
		}
	}
}
