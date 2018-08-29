package com.study.gupao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 价格计算上下文类
 *
 * @author 善变时光
 * @since 2018/5/8
 **/
public class StrategyContext {

    private Map<UserLevel,PriceCompute> strategyMap;


    public void addStrategy(UserLevel userLevel,PriceCompute priceCompute){
        if(strategyMap == null){
            strategyMap = new HashMap<>();
        }
        strategyMap.put(userLevel,priceCompute);
    }


    public float computePrice(UserLevel userLevel,float price){
        return strategyMap.get(userLevel).computePrice(price);
    }
}
