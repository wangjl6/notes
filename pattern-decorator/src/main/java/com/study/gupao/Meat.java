package com.study.gupao;

/**
 * 荤菜
 *
 * @author 善变时光
 * @since 2018/6/27
 **/
public class Meat extends Decorator{

    public Meat(Food food) {
        super(food);
    }

    @Override
    public String getName() {
        return "荤菜";
    }

    @Override
    public Float getPrice() {
        return decoratorFood.getPrice()+5;
    }
}
