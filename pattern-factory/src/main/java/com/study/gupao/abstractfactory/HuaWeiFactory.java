package com.study.gupao.abstractfactory;

import com.study.gupao.Factory;
import com.study.gupao.HuaWeiPhone;
import com.study.gupao.Phone;

/**
 * 华为工厂
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public class HuaWeiFactory implements Factory {
    @Override
    public Phone productionPhone() {
        return new HuaWeiPhone();
    }
}
