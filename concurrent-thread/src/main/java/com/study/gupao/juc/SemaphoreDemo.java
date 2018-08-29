package com.study.gupao.juc;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Semaphor，用于多线程情况下，操作限定的资源。
 * 通过信号灯可以控制当次并发的线程数
 *
 * @author BigWang
 * @createTime 2018/8/26
 **/
public class SemaphoreDemo {

    public static void main(String[] args) {
        //初始化信号灯，并定义可执行令牌数
        Semaphore semaphore = new Semaphore(3);
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            threads.add(new Thread(()->{
                try {
                    //获取令牌，acquire(令牌数)
                    semaphore.acquire(3);
                    System.out.println("执行线程："+Thread.currentThread().getName());
                    Thread.sleep(1000);
                    //释放令牌
                    semaphore.release(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }

        for(Thread thread:threads){
            thread.start();
        }
    }
}
