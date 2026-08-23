package com.foxinsurance.training.lesson3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson3App {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(Lesson3Config.class)) {
			System.out.println(context.getBean(AnnotatedQuoteService.class).quoteFor("Ava", 1200));
		}
	}
}
