package com.gupao.microservices.springboot.annotation;


import com.gupao.microservices.springboot.context.CustomImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = CustomImportBeanDefinitionRegistrar.class)
public @interface MyBean {
}
