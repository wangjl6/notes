package com.study.gupao.abstractfactory;

import com.study.gupao.abstractfactory.PhoneFactory;

/**
 * 工程测试类
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public class FactoryTest {

    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        System.out.println(factory.getHuaWeiPhone());
    }
}


