package com.study.gupao.washroom;

import java.util.ArrayList;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/23
 **/
public class App {

    public static void main(String[] args) {
        Washroom washroom = new Washroom();

        Thread thread1 = new Thread(()->{
            washroom.takeShit("张三");
        });
        Thread thread2 = new Thread(()->{
            washroom.takeShit("李四");
        });
        Thread thread3 = new Thread(()->{
            washroom.takeShit("王五");
        });
        Thread thread4 = new Thread(()->{
            washroom.fix();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
