package com.study.gopao.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/14
 **/
@Configuration
public class Config {

    @Autowired
    public User user;

    public Food food;

    public Config(Food food) {
        this.food = food;
    }

    public void config(){
        System.out.println(user);
        System.out.println(food);
    }
}
