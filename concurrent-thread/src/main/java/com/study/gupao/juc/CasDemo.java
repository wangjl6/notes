package com.study.gupao.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * compareAndSwap提供了非阻塞的同步操作，利用了计算机底层的检查冲突机制，对要操作的变量进行线程干扰比对且替换
 * 跟synchronized区别在于synchronized是悲观锁阻塞操作
 *
 * @author BigWang
 * @createTime 2018/8/26
 **/
public class CasDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerCasDemo casDemo = new AtomicIntegerCasDemo();
        casDemo.run(20,1000);
        System.out.println(casDemo.number.get());

        AtomicReferenceCasDemo atomicReferenceCasDemo = new AtomicReferenceCasDemo();
        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    atomicReferenceCasDemo.increase();
                }
            });
            thread.start();
            thread.join();
        }
        System.out.println(atomicReferenceCasDemo.reference.get().getNumber());
    }

    /**
     * 对象cas操作例子
     */
    static class AtomicReferenceCasDemo{
        private AtomicReference<MyObject> reference = new AtomicReference<MyObject>();

        public void increase(){
            for(;;){
                MyObject myObject = reference.get();
                MyObject swapMyObject = new MyObject();
                if(myObject == null){
                    swapMyObject.setNumber(0);
                    reference.compareAndSet(myObject,swapMyObject);
                }else{
                    swapMyObject.setNumber(myObject.getNumber()+1);
                    if(reference.compareAndSet(myObject,swapMyObject)){
                        break;
                    }
                }
            }
        }
    }
    static class MyObject {

        private int number = 0;

        public void setNumber(int number){
            this.number = number;
        }

        public int getNumber(){
            return number;
        }
    }

    /**
     * 基础类型cas例子
     */
    static class AtomicIntegerCasDemo{
        private  AtomicInteger number = new AtomicInteger(0);
        private  void increaseNumber(){
            while (true) {
                int curr = number.get();
                //检查是否有其他线程干扰，有则继续循环无则进行替换
                if(number.compareAndSet(curr,curr+1)){
                    break;
                }
            }
        }

        public  void run(int threadNumber,final int loopNumber){
            Thread[] threads = new Thread[threadNumber];
            for (int i = 0; i < threads.length; i++) {
                Thread thread = new Thread(()->{
                    for (int j = 0; j < loopNumber; j++) {
                        increaseNumber();
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
        }
    }

    /**
     * 基础类型简单使用例子
     */
    static class AtomicIntegerSimpleDemo{
        private static AtomicInteger number = new AtomicInteger(0);

        public static void run(int threadNumber,final int loopNumber){
            Thread[] threads = new Thread[threadNumber];
            for (int i = 0; i < threads.length; i++) {
                Thread thread = new Thread(()->{
                    for (int j = 0; j < loopNumber; j++) {
                        number.incrementAndGet();
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
        }
    }
}
