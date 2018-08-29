package com.study.gupao.reentrantlock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 为保证变量提高被读效率同时又得保证写线程安全
 * @author BigWang
 * @createTime 2018/8/24
 **/
public class ReentrantReadWriteLockDemo {

    private static ReentrantReadWriteLock reentrantReadWriteLock =
            new ReentrantReadWriteLock();
    /**
     * 读锁
     */
    private static Lock readLock = reentrantReadWriteLock.readLock();

    /**
     * 写锁
     */
    private static Lock writeLock = reentrantReadWriteLock.writeLock();

    private  int number;

    private int getNumber() {
        readLock.lock();
        try {
            return number;
        }finally {
            readLock.unlock();
        }
    }

    private   void increase(){
        writeLock.lock();
        try{
            Thread.sleep(100);
            this.number++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }
    public  void run(int threadCount,int loopCount){
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < loopCount; j++) {
                    increase();
                }
            });
            thread.start();
            threads.add(thread);
        }
        //等到所有线程执行完后，主线程继续执行
        for (Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getNumber());
    }
    public static void main(String[] args) {
        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo =
                new ReentrantReadWriteLockDemo();
        reentrantReadWriteLockDemo.run(10,10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println("读线程会等待写线程："+reentrantReadWriteLockDemo.getNumber());
            }).start();
        }
    }
}
