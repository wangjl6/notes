package com.study.gupao.reentrantlock;

import java.util.concurrent.locks.StampedLock;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/26
 **/
public class StampedLockDemo {

    private static  StampedLock stampedLock = new StampedLock();

    private int i = 0;

    public int getI(){
        long s = stampedLock.tryOptimisticRead();
        try {
            return i;
        }finally {
        }

    }

    public void increase(){
        i++;
    }

    public static void main(String[] args) {

    }
}
