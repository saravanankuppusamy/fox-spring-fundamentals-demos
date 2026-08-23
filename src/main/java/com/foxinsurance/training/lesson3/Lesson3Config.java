package com.foxinsurance.training.lesson3;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses = AnnotatedQuoteService.class)
@PropertySource("classpath:fox.properties")
public class Lesson3Config {
}
