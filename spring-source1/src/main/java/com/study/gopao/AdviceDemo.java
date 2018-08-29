package com.study.gopao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 快！写点注释
 *
 * @author BigWang
 * @since 2018/7/17
 **/
@Aspect
@Component
public class AdviceDemo{

	@Around("execution(* com..*.*(..))")
	public void before(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature=(MethodSignature)joinPoint.getSignature();
		Method method=signature.getMethod();
		System.out.println("方法规则拦截方式:"+method.getName());
		joinPoint.proceed();
	}
}
