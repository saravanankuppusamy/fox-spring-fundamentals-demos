package com.foxinsurance.training.lesson7;

import com.foxinsurance.training.data.*;
import org.springframework.context.annotation.*;

@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackageClasses = JdbcPolicyDao.class)
public class Lesson7Config {
	@Bean
	SchemaInitializer schemaInitializer(org.springframework.jdbc.core.simple.JdbcClient jdbc) {
		return new SchemaInitializer(jdbc);
	}
}
