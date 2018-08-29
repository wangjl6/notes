package com.study.gupao.abstractfactory;

import com.study.gupao.HuaWeiPhone;
import com.study.gupao.IPhone;
import com.study.gupao.MiPhone;
import com.study.gupao.Phone;

/**
 * 对不同产品组工程再进行一层抽象
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public class PhoneFactory extends AbstractFactory{
    @Override
    public Phone getMiPhone() {
        return new MIFactory().productionPhone();
    }

    @Override
    public Phone getIPhone() {
        return new MIFactory().productionPhone();
    }

    @Override
    public Phone getHuaWeiPhone() {
        return new MIFactory().productionPhone();
    }
}
