package com.study.gupao.abstractfactory;

import com.study.gupao.Factory;
import com.study.gupao.MiPhone;
import com.study.gupao.Phone;

/**
 * 小米工厂
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public class MIFactory implements Factory{

    @Override
    public Phone productionPhone() {
        return new MiPhone();
    }
}
