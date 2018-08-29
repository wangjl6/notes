package com.study.gupao.client;

import com.study.gupao.dto.RequestBody;
import com.study.gupao.dto.ResponseBody;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 快！写点注释
 *
 * @author BigWang
 * @since 2018/7/1
 **/
public class RomateInstance implements InvocationHandler {

    private Class clazz;

    public  <T> T getInstance(final Class<T> interfaceCls){
        this.clazz = interfaceCls;
        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),new Class[]{interfaceCls},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RequestBody requestBody = new RequestBody();
        requestBody.setMethod(method.getName());
        requestBody.setClazz(clazz);
        requestBody.setArgs(args);
        System.out.println("==========客户端发送请求========"+requestBody);
        ResponseBody responseBody = Client.connectionServer(requestBody);
        System.out.println("==========客户端接收结果========"+responseBody);
        return responseBody.getData();
    }
}
