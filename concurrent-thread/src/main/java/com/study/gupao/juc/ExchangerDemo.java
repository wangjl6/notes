package com.study.gupao.juc;

import java.util.concurrent.Exchanger;

/**
 * 用于两个线程之间数据相互传递，在接受到消息前都会进行等待
 *
 * @author BigWang
 * @createTime 2018/8/26
 **/
public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"发送消息：你好");
                Object returnVal = exchanger.exchange("你好");
                System.out.println(Thread.currentThread().getName()+"接收消息："+returnVal);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"发送消息：你也好");
                Thread.sleep(2000);
                Object returnVal = exchanger.exchange("你也好");
                System.out.println(Thread.currentThread().getName()+"接收消息："+returnVal);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
