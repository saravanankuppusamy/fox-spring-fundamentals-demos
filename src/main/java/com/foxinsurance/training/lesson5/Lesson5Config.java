package com.foxinsurance.training.lesson5;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = PolicyIssuanceServiceImpl.class)
public class Lesson5Config {
}
