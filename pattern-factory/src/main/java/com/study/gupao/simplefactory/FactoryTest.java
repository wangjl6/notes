package com.study.gupao.simplefactory;

import com.study.gupao.Factory;

/**
 * 工程测试类
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public class FactoryTest {

    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        System.out.println(factory.productionPhone("苹果"));
    }
}


