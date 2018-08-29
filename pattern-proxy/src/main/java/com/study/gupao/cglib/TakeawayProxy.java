package com.study.gupao.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 外卖代理类
 *
 * @author 善变时光
 * @since 2018/4/23
 **/
public class TakeawayProxy implements MethodInterceptor {

    /**
     * 获取具体代理实例
     * @param clazz
     * @return
     */
    public Object getInstance(Class<?> clazz){
        //需要借用Enhancer类来集成并设置回调类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    /**
     * 代理类执行方法
     * @param o 被代理类
     * @param method    被代理方法
     * @param objects   被代理方法参数
     * @param methodProxy   方法代理对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName());
        System.out.println("=======收到您的订单=======");
        //必须要使用该方法  不然会陷入不断调用的死循环 调用又被代理又被调用
        methodProxy.invokeSuper(o,objects);
        System.out.println("=======开始派送您的外卖====");
        return null;
    }
}
