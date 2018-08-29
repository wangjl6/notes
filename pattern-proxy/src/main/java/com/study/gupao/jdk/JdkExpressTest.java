package com.study.gupao.jdk;

/**
 * jdk动态代理测试类
 *
 * @author 善变时光
 * @since 2018/4/23
 **/
public class JdkExpressTest {
    public static void main(String[] args) {
        Express express =  (Express) new ExpressProxy().getInstance(new MyExpress());
        express.toString();//会被代理toString方法
        express.sendByExpress();//会被代理sendByExpress方法

    }
}
