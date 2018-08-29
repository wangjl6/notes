package com.study.gupao.waite;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.study.gupao.waite.SleepUtil.randomSleep;

/**
 * 服务员
 *
 * @author BigWang
 * @createTime 2018/8/23
 **/
public class Waiter extends Thread{

    private Queue<String>foodsQueue;
    private String name;

    public Waiter(String name,Queue foodsQueue) {
        System.err.println(name+"初始化");
        this.foodsQueue = foodsQueue;
        this.name = name;
    }

    public void work() throws InterruptedException {
        while(true) {
            synchronized (foodsQueue) {
                while (foodsQueue.isEmpty()) {
                    System.err.println(name + ",开始休息，等厨师炒菜！");
                    foodsQueue.wait();
                }
                System.err.println(name + ",开始上菜！,还剩下"+foodsQueue.size());
                foodsQueue.remove();
                foodsQueue.notifyAll();
            }
            int millis = randomSleep();
            System.err.printf("%s上菜，用时%s \n",name,millis);
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
