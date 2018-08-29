package com.study.gupao;

/**
 * 会员价格计算
 *
 * @author 善变时光
 * @since 2018/5/8
 **/
public class VipPriceCompute implements PriceCompute {
    @Override
    public float computePrice(float price) {
        return (float) (price*0.8);
    }
}
