package com.study.gupao.abstractfactory;

import com.study.gupao.Factory;
import com.study.gupao.IPhone;
import com.study.gupao.Phone;

/**
 * 苹果工厂
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public class AppleFactory implements Factory {
    @Override
    public Phone productionPhone() {
        return new IPhone();
    }
}
