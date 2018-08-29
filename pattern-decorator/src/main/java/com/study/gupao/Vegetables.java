package com.study.gupao;

/**
 * 素菜
 *
 * @author 善变时光
 * @since 2018/6/27
 **/
public class Vegetables extends Decorator{

    public Vegetables(Food food) {
        super(food);
    }

    @Override
    public String getName() {
        return "素菜";
    }

    @Override
    public Float getPrice() {
        return decoratorFood.getPrice()+3;
    }
}
