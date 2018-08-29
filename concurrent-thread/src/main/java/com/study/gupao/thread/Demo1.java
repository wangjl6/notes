 package com.study.gupao.thread;

 import static java.lang.Thread.sleep;

 /**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/7/31
 **/
public class Demo1{

    public static Object lock = new Object();

     public   boolean flag = true;



    public  int number = 0;

     /**
      * 执行number++非线程安全操作
      */
    public synchronized void increase(){
            this.number++;
    }


    public static void run(int threadNumber,final int loopNumber){

        Thread[] threads = new Thread[threadNumber];
        Demo1 demo1 = new Demo1();
        for (int i = 0; i < threads.length; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < loopNumber; j++) {
                    demo1.increase();
                }
            });
            thread.start();
            threads[i] = thread;
        }
        for(Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(demo1.number);
    }


    public static void test(){
        Demo1 demo1 = new Demo1();
        Thread thread = new Thread(() -> {
            while(demo1.flag){
                Thread.yield();
            }
            System.out.println(demo1.number);;
        });
        thread.start();
        demo1.number++;
        demo1.flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("多线程开始执行");

         //原子性
        /*run(20,100);
        run(20,200);
        run(20,300);
        run(20,400);*/
        Demo1 demo1 = new Demo1();

       // 内存可见性，不同线程修改变量时，其他线程不可见
       Thread thread = new Thread(() -> {
            while(demo1.flag){
//                System.out.println(flag);
            }
            System.out.println("done。。。。。。");
        });

        Thread thread2 = new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo1.flag = false;
            System.out.println("flag done。。。。。。");
        });
        thread.start();
        thread2.start();


//        for (int i = 0; i < 100; i++) {
//            test();
//        }




        //线程状态分为NEW创建未执行、RUNNABLE正在执行、WAITE等待、TIMED_WAITING超时等待、TERMINATED终止
        /*Thread thread = new Thread(()->{
            try {
                synchronized (lock){
                    System.out.println("waite等待开始。。。");
                    lock.wait(5000);
                    System.out.println("waite等待结束。。。");
                    printThreadState(Thread.currentThread());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        printThreadState(thread);
        thread.start();
        printThreadState(thread);
        sleep(2000);
        printThreadState(thread);
        synchronized (lock){
            System.out.println("notify唤醒开始。。。");
            lock.notify();
            printThreadState(thread);
            System.out.println("notify唤醒结束");
        }
        thread.join();
        printThreadState(thread);
        System.out.println("多线程结束执行");*/
    }


    public static void printThreadState(Thread thread){
        System.out.printf("%s线程的状态为%s \n",thread.getName()
                ,thread.getState());
    }
}
