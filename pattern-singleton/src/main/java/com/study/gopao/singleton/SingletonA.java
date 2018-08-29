package com.study.gopao.singleton;

import java.io.Serializable;

/**
 * 单例模式
 *
 * @author 善变时光
 * @since 2018/4/2
 **/
public class SingletonA implements Serializable {

    /**
     * 单例模式必须要有私有构造方法，否则会被new出两个实例
     */
    private SingletonA(){

    }

    /**
     * 避免反射修改getInstance方法
     * @return SingletonA
     */
    public final static SingletonA getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 内部类只有在类加载的时候才会初始化，符合饿汉模式原则
     */
    private static class  SingletonHolder {
        public final static  SingletonA INSTANCE = new SingletonA();
    }

    /**
     * 反序列化时避免发生两个实例情况时调用
     * @return SingletonA
     */
    private Object readResovle(){
        return SingletonHolder.INSTANCE;
    }
}
