package com.study.gupao;

import com.sun.xml.internal.ws.server.provider.AsyncProviderInvokerTube;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Spring启动类
 *
 * @author 善变时光
 * @since 2018/6/26
 **/
@ComponentScan(basePackages = "com.study.gupao")
@EnableAutoConfiguration
@SpringBootApplication
public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(SpringTest.class);
        Event event1 = new Event(SpringTest.class);
        event1.setMessage("我是事件1");

        Event event2 = new Event(SpringTest.class);
        event2.setMessage("我是事件2");

        Event event3 = new Event(SpringTest.class);
        event3.setMessage("我是事件3");


        annotationConfigApplicationContext.publishEvent(event1);
        annotationConfigApplicationContext.publishEvent(event2);
        annotationConfigApplicationContext.publishEvent(event3);
    }
}
