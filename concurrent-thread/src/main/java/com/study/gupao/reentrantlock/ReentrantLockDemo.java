package com.study.gupao.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 显示锁
 *
 * @author BigWang
 * @createTime 2018/8/23
 **/
public class ReentrantLockDemo {

    private  static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        Thread thead1 = new Thread(()->run());
        thead1.setName("线程1");
        Thread thead2 = new Thread(()->run());
        thead2.setName("线程2");
        thead1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thead2.start();
        System.out.printf("%s线程状态为%s \n",thead1.getName(),thead1.getState());
        System.out.printf("%s线程状态为%s \n",thead2.getName(),thead2.getState());
    }

    public static void run(){
        for(;;){
            System.out.printf("%s尝试获取锁 \n",Thread.currentThread().getName());
            if(reentrantLock.tryLock()){
                System.out.printf("%s得到锁 \n",Thread.currentThread().getName());
                //加上锁，避免和tryLock()重复使用
//                reentrantLock.lock();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    //一定要释放锁
                    reentrantLock.unlock();
                    System.out.printf("%s释放锁 \n",Thread.currentThread().getName());
                    break;
                }
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
