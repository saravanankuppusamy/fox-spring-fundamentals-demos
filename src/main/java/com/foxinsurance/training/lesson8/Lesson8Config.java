package com.foxinsurance.training.lesson8;

import com.foxinsurance.training.data.*;
import com.foxinsurance.training.lesson6.PolicyDao;
import com.foxinsurance.training.lesson7.JdbcPolicyDao;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackageClasses = PolicyPurchaseService.class)
public class Lesson8Config {
	@Bean
	PolicyDao policyDao(JdbcClient jdbc) {
		return new JdbcPolicyDao(jdbc);
	}

	@Bean
	SchemaInitializer schemaInitializer(JdbcClient jdbc) {
		return new SchemaInitializer(jdbc);
	}
}
