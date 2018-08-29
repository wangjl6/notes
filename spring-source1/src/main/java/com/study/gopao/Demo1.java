package com.study.gopao;


import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 快！写点注释
 *
 * @author BigWang
 * @since 2018/7/17
 **/
@ComponentScan("com.*")
@EnableAspectJAutoProxy
public class Demo1 {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(Demo1.class);
		/*context.register(AppDemo.class);
		context.register(AdviceDemo.class);
		context.refresh();*/

		AppDemo appDemo = context.getBean(AppDemo.class);
		appDemo.sayHello();
	}
}
