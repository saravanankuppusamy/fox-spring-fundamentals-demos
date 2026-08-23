package com.foxinsurance.training.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson2App {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext();
		if (args.length > 0)
			context.getEnvironment().setActiveProfiles(args[0]);
		context.register(Lesson2Config.class);
		context.refresh();
		System.out.println("Company: " + context.getBean("companyName"));
		System.out.println(context.getBean(NotificationChannel.class).send("Your Fox Insurance quote is ready."));
		var a = context.getBean(QuoteSession.class);
		var b = context.getBean(QuoteSession.class);
		System.out.println("Prototype bean IDs differ: " + a.id() + " vs " + b.id());
		System.out.println("Requesting lazy bean now...");
		System.out.println(context.getBean(ExpensiveRiskModel.class).version());
		context.close();
	}
}
