package com.study.gupao.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/26
 **/
public class ThreadLocalDemo {

    private final static ThreadLocal local = new ThreadLocal<List<Integer>>();

    public void set(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        local.set(integers);
    }

    public Object get(){
        return local.get();
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();

        new Thread(()->{
            demo.set();
            List<Integer> list = (List<Integer>) demo.get();
            list.clear();
            System.out.printf("%s线程的list为：%s \n",Thread.currentThread().getName(),list);
        }).start();

        new Thread(()->{
            demo.set();
            List<Integer> list = (List<Integer>) demo.get();
            list.add(5);
            System.out.printf("%s线程的list为：%s \n",Thread.currentThread().getName(),list);
        }).start();

        new Thread(()->{
            demo.set();
            List<Integer> list = (List<Integer>) demo.get();
            list.remove(0);
            list.add(10);
            System.out.printf("%s线程的list为：%s \n",Thread.currentThread().getName(),list);
        }).start();
    }
}
