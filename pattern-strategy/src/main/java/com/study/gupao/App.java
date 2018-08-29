package com.study.gupao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StrategyContext strategyContext = new StrategyContext();
        //添加vip会员价格计算策略
        strategyContext.addStrategy(UserLevel.VIP,new VipPriceCompute());
        //添加飞会员价格计算策略
        strategyContext.addStrategy(UserLevel.NORMAL,new NormalPriceCompute());
        //vip会员价格
        System.out.println(strategyContext.computePrice(UserLevel.VIP,10));
        //非会员的价格
        System.out.println(strategyContext.computePrice(UserLevel.NORMAL,10));
    }
}
