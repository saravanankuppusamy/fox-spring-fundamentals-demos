package com.foxinsurance.training.lesson5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
	@Before("execution(* com.foxinsurance.training.lesson5.PolicyIssuanceService.*(..))")
	public void beforePolicyCall() {
		System.out.println("[AOP @Before] policy operation requested");
	}

	@AfterReturning(pointcut = "execution(* com.foxinsurance.training.lesson5.PolicyIssuanceService.issuePolicy(..))", returning = "policyNumber")
	public void afterPolicyIssued(Object policyNumber) {
		System.out.println("[AOP @AfterReturning] issued " + policyNumber);
	}

	@Around("execution(* com.foxinsurance.training.lesson5.PolicyIssuanceService.*(..))")
	public Object time(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();
		try {
			return pjp.proceed();
		} finally {
			System.out.printf("[AOP @Around] %s took %d microseconds%n", pjp.getSignature().getName(),
					(System.nanoTime() - start) / 1000);
		}
	}
}
