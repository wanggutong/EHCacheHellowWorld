package com.ehcache.helloworld.ehcachehelloworld.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	@Around("execution(* com.ehcache.helloworld.ehcachehelloworld.controller.FastJsonController..*(..))")
	public Object method(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("=====Aspect Handle=======");
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("parameter is:" + arg);
		}
		long start = System.currentTimeMillis();
		Object object = pjp.proceed();
		System.out.println("Aspect Time:" + (System.currentTimeMillis() - start));
		return object;
	}
}
