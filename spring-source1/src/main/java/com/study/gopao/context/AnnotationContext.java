package com.study.gopao.context;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/14
 **/
@Configuration
@Order
@ComponentScan(basePackages = "com.study.gopao.context")
public class AnnotationContext {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationContext.class);
        context.addApplicationListener(new MyApplicationListener());
        Config config = (Config) context.getBean("config");
        config.config();
//        User user = (User) context.getBean("user");
//        System.out.println(user);
//        User user1 = new User();
//        System.out.println(user1);
        System.out.println(context.getBean(MyApplicationListener.class));

    }


    static class MyApplicationListener implements ApplicationListener{
        @Override
        public void onApplicationEvent(ApplicationEvent event) {

        }
    }



}
