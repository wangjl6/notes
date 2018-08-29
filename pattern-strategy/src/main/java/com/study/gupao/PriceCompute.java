package com.study.gupao;

/**
 * 价格计算
 *
 * @author 善变时光
 * @since 2018/5/8
 **/
public interface PriceCompute {

    /**
     * 价格计算方法
     * @param price 价格
     * @return 实际价格
     */
    float computePrice(float price);
}
