package com.study.gupao.dto;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 请求实体
 *
 * @author 善变时光
 * @since 2018/7/1
 **/
public class RequestBody implements Serializable {

    private Class clazz;

    private String method;

    private Object [] args;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }


    @Override
    public String toString() {
        return "RequestBody{" +
                "clazz=" + clazz +
                ", method=" + method +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
