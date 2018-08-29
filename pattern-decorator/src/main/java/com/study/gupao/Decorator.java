package com.study.gupao;

/**
 * 装饰类
 *
 * @author 善变时光
 * @since 2018/6/27
 **/
public class Decorator extends Food {

    protected Food decoratorFood;

    public Decorator(Food food) {
        this.decoratorFood = food;
    }
}
