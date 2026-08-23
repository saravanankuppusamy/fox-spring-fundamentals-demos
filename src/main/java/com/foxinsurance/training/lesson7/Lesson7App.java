package com.foxinsurance.training.lesson7;

import com.foxinsurance.training.lesson6.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lesson7App {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(Lesson7Config.class)) {
			var dao = context.getBean(PolicyDao.class);
			long id = dao.create(new PolicyRecord(null, "Mia", "HOME", 980, "ACTIVE"));
			System.out.println("Inserted id=" + id);
			System.out.println("Found=" + dao.findById(id));
			dao.updateStatus(id, "RENEWAL_DUE");
			System.out.println("All=" + dao.findAll());
		}
	}
}
