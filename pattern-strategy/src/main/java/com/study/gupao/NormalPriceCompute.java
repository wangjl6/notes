package com.study.gupao;

/**
 * 普通价格计算
 *
 * @author 善变时光
 * @since 2018/5/8
 **/
public class NormalPriceCompute implements PriceCompute {
    @Override
    public float computePrice(float price) {
        return price;
    }
}
