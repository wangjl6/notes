package com.study.gupao.myproxy;

import java.lang.reflect.Method;

/**
 * 代理接口类
 *
 * @author 善变时光
 * @since 2018/4/23
 **/
public interface MyInvocationHandler {


    /**
     * 代理反射调用接口方法
     * @param object 新的代理对象
     * @param method 代理的方法
     * @param args 代理方法参数
     * @return
     */
    public Object invoke(Object object, Method method,Object...args);
}
