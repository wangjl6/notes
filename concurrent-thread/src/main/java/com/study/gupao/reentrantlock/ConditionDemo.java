package com.study.gupao.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/26
 **/
public class ConditionDemo {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                reentrantLock.lock();
                try {
                    System.out.printf("%s线程开始执行 \n",Thread.currentThread().getName());
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
                System.out.printf("%s线程完成执行 \n",Thread.currentThread().getName());
            }).start();
        }

        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.printf("%s线程开始唤醒 \n",Thread.currentThread().getName());
                reentrantLock.lock();
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }).start();
    }

}
