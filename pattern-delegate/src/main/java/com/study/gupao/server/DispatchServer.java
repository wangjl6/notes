package com.study.gupao.server;

import com.study.gupao.api.IUserService;
import com.study.gupao.api.impl.UserServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 委派类
 *
 * @author 善变时光
 * @since 2018/7/1
 **/
public class DispatchServer {

    public static Object dispatch(Class clazz, String methodName,Object [] args){
        try {
            List<Class> argsClasList = new ArrayList<>();
            if(args!=null){
                for(Object arg:args){
                    argsClasList.add(arg.getClass());
                }
            }

            Method method = clazz.getMethod(methodName,argsClasList.toArray(new Class[0]));
            return "123123";
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clazz = IUserService.class;
        Method method = clazz.getMethod("getUsername",null);
        System.out.println(method.invoke(clazz.newInstance(),new Object []{}));;
    }
}
