package com.example.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.example.service.*.*(..))")
	public void logMethodCallBefore(JoinPoint joinPoint) {
		LOGGER.info("Before Method called " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.example.service.*.*(..))")
	public void logMethodCallAfter(JoinPoint joinPoint) {
		LOGGER.info("After Method called " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* com.example.service.*.*(..))")
	public void logMethodCallAfterReturning(JoinPoint joinPoint) {
		LOGGER.info("After Returning Method called " + joinPoint.getSignature().getName());
	}

	@AfterThrowing("execution(* com.example.service.*.*(..))")
	public void logMethodCallAfterThrowing(JoinPoint joinPoint) {
		LOGGER.info("After Throwing Method called " + joinPoint.getSignature().getName());
	}
}