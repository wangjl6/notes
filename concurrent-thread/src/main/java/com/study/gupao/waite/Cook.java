package com.study.gupao.waite;

import java.util.Queue;

import static com.study.gupao.waite.SleepUtil.randomSleep;

/**
 * 厨师
 *
 * @author BigWang
 * @createTime 2018/8/23
 **/
public class Cook extends Thread{

    private Queue<String> foodsQueue;
    private String name;

    public Cook(String name,Queue foodsQueue) {
        System.out.println(name+"初始化");
        this.foodsQueue = foodsQueue;
        this.name = name;
    }

    public void work() throws InterruptedException {

        while(true) {
            synchronized (foodsQueue) {
                while (foodsQueue.size() > 3) {
                    System.out.println("上菜超过上限了，" + name + "厨师开始休息！");
                    foodsQueue.wait();
                }
                System.out.println("" + name + "厨师开始炒菜！"+foodsQueue.size());
                int millis = randomSleep();
                System.out.printf("%s炒菜菜，用时%s \n",name,millis);

                foodsQueue.add(name + "炒的菜");
                foodsQueue.notifyAll();
            }

        }
    }


    @Override
    public void run() {
        try {
            work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
