package com.foxinsurance.training.lesson5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.aop.support.AopUtils;

public class Lesson5App {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(Lesson5Config.class)) {
			var service = context.getBean(PolicyIssuanceService.class);
			System.out.println("Is Spring proxy? " + AopUtils.isAopProxy(service));
			System.out.println("Policy=" + service.issuePolicy("Noah", "travel"));
		}
	}
}
