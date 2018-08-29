package com.study.gopao.demo2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/7/31
 **/
public class App {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(MyProcessor.class,(definition)->{
        });
        context.addBeanFactoryPostProcessor(configurableListableBeanFactory->{
            configurableListableBeanFactory.addBeanPostProcessor(new MyProcessor());
        });
        context.refresh();
    }


    static class MyProcessor implements BeanPostProcessor,Ordered{
        @Nullable
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("加载前"+beanName);
            if(bean instanceof MyProcessor){
                MyProcessor var1 =(MyProcessor)bean;
                System.out.println(var1);
            }
            ReflectionUtils.doWithMethods(bean.getClass(),(mc)->{
                mc.setAccessible(true);
            });
            ReflectionUtils.doWithFields(bean.getClass(),field -> {
            });
            return bean;
        }

        @Nullable
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("加载后"+beanName);
            return bean;
        }

        @Override
        public int getOrder() {
            return 10;
        }
    }
}
