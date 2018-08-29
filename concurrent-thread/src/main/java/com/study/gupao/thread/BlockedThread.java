package com.study.gupao.thread;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/22
 **/
public class BlockedThread {

    public static void main(String[] args) {

        //线程1
        Thread thread1 = new Thread(()->{
            run();
        });
        thread1.setName("线程1");

        //线程2
        Thread thread2 = new Thread(()->{
            run();
        });
        thread2.setName("线程2");
        thread1.start();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }

    /**
     * 当锁被线程1拿走且不归还时、线程2就进入阻塞队列等待锁其状态就为BLOCKED
     */
    public static void run(){

        while (true){
            synchronized (BlockedThread.class){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
