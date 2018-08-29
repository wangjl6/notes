package com.study.gupao.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 *
 * @author 善变时光
 * @since 2018/4/23
 **/
public class ExpressProxy implements InvocationHandler {

    private Object object;

    /**
     * 生成新的代理对象
     * @param target 代理对象
     * @return Proxy新代理对象
     */
    public Object getInstance(Object target){
        this.object = target;
        Class clazz = target.getClass();
        //jdk动态代理需要靠此方法进行字节码重组生成代理类
        //jdk动态代理的缺陷就是非得是接口实现
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    /**
     * 代理对象实现代理
     * 这样搞的话被代理类的任何方法都会被代理一遍，比如简单的print，代理类都会执行
     * @param proxy 新的代理对象
     * @param method 被代理的方法
     * @param args 被代理方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        System.out.println("========开始接收您的快递=======");
        method.invoke(object,args);
        System.out.println("========完成派送您的快递=======");
        return null;
    }
}
