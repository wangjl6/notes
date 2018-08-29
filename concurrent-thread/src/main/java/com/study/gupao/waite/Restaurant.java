package com.study.gupao.waite;

import java.util.*;

/**
 * 餐馆
 *
 * @author BigWang
 * @createTime 2018/8/23
 **/
public class Restaurant {

    public static void main(String[] args) {
        Queue queue = new ArrayDeque();
        List<Thread> threads= new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Cook cook = new Cook("厨师"+i,queue);
            threads.add(cook);
            Waiter waiter = new Waiter("服务员"+i,queue);
            threads.add(waiter);
        }

//        threads.add(new Waiter("服务员"+1,queue));
//        threads.add(new Waiter("服务员"+2,queue));

        for (Thread thread:threads){
            thread.start();
        }
    }
}
