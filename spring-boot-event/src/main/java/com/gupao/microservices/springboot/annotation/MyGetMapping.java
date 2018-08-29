package com.gupao.microservices.springboot.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/13
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(
    method = {RequestMethod.GET}
)
public @interface MyGetMapping {

    @AliasFor(annotation = RequestMapping.class)
    String [] value() default {};
}
