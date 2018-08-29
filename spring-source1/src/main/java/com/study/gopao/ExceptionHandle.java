package com.study.gopao;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 快！写点注释
 *
 * @author BigWang
 * @since 2018/7/18
 **/
@Component
@Aspect
public class ExceptionHandle{

    @AfterThrowing(throwing = "ex",pointcut=" execution(* com..*.*(..))",argNames="object,ex")
    public void afterThrowing(Object object, Exception ex) throws Throwable {
        System.out.println(object);
    }
}
