package com.study.gopao.demo1;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.concurrent.*;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/7/26
 **/
public class Demo{

    public static void main(String[] args) {
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();

        genericApplicationContext.refresh();
        ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext();
        context.setParent(genericApplicationContext);
        context.addApplicationListener((applicationEvent)->{
            System.out.printf("当前事件为%s \n",applicationEvent);
        });
		context.setConfigLocation("classpath:application.xml");
		context.refresh();
        context.getEnvironment().getPropertySources().forEach(p->{
            System.out.println(p.getSource());
        });

        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(Executors.newSingleThreadExecutor());



    }

}
