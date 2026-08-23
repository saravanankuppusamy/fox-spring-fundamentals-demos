package com.foxinsurance.training.lesson9;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = JpaPolicyRepository.class)
public class Lesson9Config {
	@Bean
	DataSource dataSource() {
		var ds = new JdbcDataSource();
		ds.setURL("jdbc:h2:mem:foxjpa;DB_CLOSE_DELAY=-1");
		ds.setUser("sa");
		return ds;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		var f = new LocalContainerEntityManagerFactoryBean();
		f.setDataSource(ds);
		f.setPackagesToScan("com.foxinsurance.training.lesson9");
		f.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		var p = new Properties();
		p.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		p.setProperty("hibernate.show_sql", "true");
		f.setJpaProperties(p);
		return f;
	}

	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
