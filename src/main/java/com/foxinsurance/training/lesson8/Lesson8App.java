package com.foxinsurance.training.lesson8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson8App {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(Lesson8Config.class)) {
			var svc = context.getBean(PolicyPurchaseService.class);
			System.out.println("Before=" + svc.policyCount());
			System.out.println("Committed policy id=" + svc.purchase("Liam", "HEALTH", 2200, false));
			try {
				svc.purchase("Emma", "AUTO", 1400, true);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("After (failed purchase rolled back)=" + svc.policyCount());
		}
	}
}
