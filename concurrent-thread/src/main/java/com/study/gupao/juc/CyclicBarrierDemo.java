package com.study.gupao.juc;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 例子
 * CyclicBarrier是控制多线程在某个代码阶段同步运行工具
 * 当线程未执行到同步标致时，其他线程都会进入等待。
 * 用CountDownLatch也可以实现同样的效果
 * CyclicBarrier可以重复使用，通过rest()方法，CountDownLatch则不行
 *
 * @author BigWang
 * @createTime 2018/8/26
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        //初始化四个线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,()->{
            System.out.println("在等待结束后，优先执行。。。");
        });
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threads.add(new Thread(()->{
                try {
                    //线程进行等待，等待其他线程执行到这步，同时继续执行
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("执行线程："+Thread.currentThread().getName());
            }));
        }

        threads.add(new Thread(()->{
            System.out.println("我是等待线程");
            try {
                //等待线程睡眠2秒，其他线程也会跟着等待
                Thread.sleep(2000);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("执行线程："+Thread.currentThread().getName());
        }));
        for(Thread thread : threads){
            thread.start();
        }
        System.out.println("我是主线程");


        //初始化四个线程
//        CountDownLatch countDownLatch = new CountDownLatch(4);
//        ArrayList<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            threads.add(new Thread(()->{
//                try {
//                    countDownLatch.countDown();
//                            //线程进行等待，等待其他线程执行到这步，同时继续执行
////                    cyclicBarrier.await();
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("执行线程："+Thread.currentThread().getName());
//            }));
//        }
//
//        threads.add(new Thread(()->{
//            System.out.println("我是等待线程");
//            try {
//                //等待线程睡眠2秒，其他线程也会跟着等待
//                Thread.sleep(2000);
//                countDownLatch.countDown();
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("执行线程："+Thread.currentThread().getName());
//        }));
//        for(Thread thread : threads){
//            thread.start();
//        }
//        System.out.println("我是主线程");
    }
}
