package com.study.gupao.waite;

import java.util.Random;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/23
 **/
public class SleepUtil {

    private static Random random = new Random();

    public static int randomSleep(){
        int millis = random.nextInt(1000);

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return millis;
    }
}
