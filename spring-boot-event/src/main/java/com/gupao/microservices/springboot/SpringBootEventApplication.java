package com.gupao.microservices.springboot;

import org.springframework.asm.ClassVisitor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


@SpringBootApplication
public class SpringBootEventApplication implements BeanPostProcessor {

	public static void main(String[] args) {
        AnnotationConfigServletWebServerApplicationContext context =
                (AnnotationConfigServletWebServerApplicationContext)
				new SpringApplicationBuilder(SpringBootEventApplication.class)
//				.properties("server.port:8989")
				.web(WebApplicationType.SERVLET)
//				.listeners((applicationEvent)-> {
//						System.err.println(Thread.currentThread().getName()+"__"+applicationEvent);
//				})
				.run(args);
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("name",String.class);
        Object o = beanGenerator.create();
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        genericApplicationContext.registerBean("aa",o.getClass());
        genericApplicationContext.refresh();
        context.setParent(genericApplicationContext);
        System.out.println(context.getBean("aa"));


        Class clazz = o.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            System.out.println(method.getName());
        });

//		context.
		/*SimpleApplicationEventMulticaster initialMulticaster = new SimpleApplicationEventMulticaster();
		ExecutorService service = Executors.newFixedThreadPool(5);
		initialMulticaster.addApplicationListener((applicationEvent)->
				System.out.println(Thread.currentThread().getName()+"___"+applicationEvent.getSource()));
		initialMulticaster.setTaskExecutor(service);
		initialMulticaster.multicastEvent(new ApplicationEvent("测试") {
			@Override
			public Object getSource() {
				return super.getSource();
			}

			@Override
			public String toString() {
				return super.toString();
			}
		});
		service.shutdown();*/
		/*context.
		context.publishEvent(new ApplicationEvent("测试") {
			@Override
			public Object getSource() {
				return super.getSource();
			}

			@Override
			public String toString() {
				return super.toString();
			}
		});*/
	}


    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
