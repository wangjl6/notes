package com.study.gupao.juc;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是作为多线程操作的一个发令枪作用
 * 可通过该工具控制多线程同时结束
 *
 * CountDownLatch例子
 * @author BigWang
 * @date 2018/8/26
 **/
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {
        //初始指令数
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            threads.add(new Thread(()->{
                System.out.println("执行线程："+Thread.currentThread().getName());
                //执行完后减一
                countDownLatch.countDown();
            }));
        }
        for(Thread thread : threads){
            thread.start();
        }
        //当指令未到0时，进入等待
        countDownLatch.await();
        System.out.println("执行主线程："+Thread.currentThread().getName());
    }
}
