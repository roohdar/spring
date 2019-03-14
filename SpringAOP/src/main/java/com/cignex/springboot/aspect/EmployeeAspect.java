package com.cignex.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAspect.class);

	// @Before("execution(*
	// com.cignex.springboot.service.EmployeeService.createEmployee(java.lang.String))
	// && args(name) ")

	@Before("execution(* com.cignex.springboot.service.*.*(..))")
	public void beforeEmployeeCreate(JoinPoint joinPoint) {
		// LOGGER.info("A request was issued for a employee name: " + name);
		LOGGER.info("Before args : ");
		Object[] signatureArgs = joinPoint.getArgs();
		for (Object signatureArg : signatureArgs) {
			LOGGER.info("Arg: " + signatureArg);

		}

	}

	@AfterReturning(pointcut = "execution(* com.cignex.springboot.service.*.*(..))", returning = "result")
	public void AfterEmployeeCreate(JoinPoint joinPoint, Object result) {

		LOGGER.info("returned with value " + result);

	}

	@After(value = "execution(* com.cignex.springboot.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		LOGGER.info("after execution of " + joinPoint);
	}

	@AfterThrowing(pointcut = "execution(* com.cignex.springboot.SpringAopApplication.*.*(..))", throwing = "result")
	public void aftherthrow(JoinPoint joinPoint, Object result) {
		LOGGER.info("returned with exception " + result.toString());
	}

	@AfterThrowing(pointcut = "execution(* com.cignex.springboot.service.*.*(..))", throwing = "result")
	public void aftherthrowing(JoinPoint joinPoint, Object result) {
		LOGGER.info("returned with exception " + result.toString());
	}

	@Pointcut("execution(* com.cignex.springboot.service.EmployeeService.createEmployee(..))")
	private void addEmp() {
	};

	@Around("addEmp()")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.err.println("Before Calling method");
		proceedingJoinPoint.proceed();
		System.err.println("after calling method");
	}

}
