package com.study.gupao;

/**
 * 米饭
 *
 * @author 善变时光
 * @since 2018/6/27
 **/
public class Reic extends Decorator{
    public Reic(Food food) {
        super(food);
    }

    @Override
    public String getName() {
        return "米饭";
    }

    @Override
    public Float getPrice() {
        return decoratorFood.getPrice()+2;
    }
}
