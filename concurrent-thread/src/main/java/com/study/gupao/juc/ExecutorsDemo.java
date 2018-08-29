package com.study.gupao.juc;

import java.util.concurrent.*;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/26
 **/
public class ExecutorsDemo {

    public static void main(String[] args) {
        //SingleThreadExecutor 创建串行的连接池，子线程按顺序执行
        /*ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(()->{
            System.out.println(Thread.currentThread().getName());
        });
        service.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        });
        //判断线程是否结束
        if(!service.isTerminated()){
            //关闭连接池
            service.shutdown();
        }*/

        //固定线程数线程池，超出会进入队列等待
        /*ExecutorService fixedService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            Future future = fixedService.submit(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //判断线程是否结束
        if(!fixedService.isTerminated()){
            //关闭连接池
            fixedService.shutdown();
        }*/

        //可配置定时任务执行的连接池
        /*ScheduledExecutorService scheduledService =
                Executors.newScheduledThreadPool(4);
        Future future = scheduledService.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName());

        },5,2,TimeUnit.SECONDS);
        //判断线程是否结束
        if(!scheduledService.isTerminated()){
            //关闭连接池
            scheduledService.shutdown();
        }*/

        ExecutorService workStealingPoolService =
                Executors.newWorkStealingPool(3);
        for (int i = 0; i < 3; i++) {
            workStealingPoolService.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        /*//判断线程是否结束
        if(!workStealingPoolService.isTerminated()){
            //关闭连接池
            workStealingPoolService.shutdown();
        }*/

    }
}
