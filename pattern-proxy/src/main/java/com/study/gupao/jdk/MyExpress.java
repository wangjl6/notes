package com.study.gupao.jdk;

/**
 * 具体执行类
 *
 * @author 善变时光
 * @since 2018/4/23
 **/
public class MyExpress implements Express {
    @Override
    public void sendByExpress() {
        System.out.println("=========我要发送快递=============");
    }
}
