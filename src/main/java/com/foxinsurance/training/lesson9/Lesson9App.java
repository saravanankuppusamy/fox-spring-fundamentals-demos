package com.foxinsurance.training.lesson9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson9App {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(Lesson9Config.class)) {
			var repo = context.getBean(JpaPolicyRepository.class);
			var policy = repo.save(new PolicyEntity("Sophia", "TRAVEL", 450, "ACTIVE"));
			System.out.println("Persisted=" + policy);
			repo.changeStatus(policy.getId(), "CLAIM_OPEN");
			System.out.println("After dirty checking=" + repo.find(policy.getId()));
			System.out.println("All=" + repo.findAll());
		}
	}
}
