package com.study.gupao.abstractfactory;

import com.study.gupao.HuaWeiPhone;
import com.study.gupao.IPhone;
import com.study.gupao.MiPhone;
import com.study.gupao.Phone;

/**
 * 抽象的工厂类
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public abstract class AbstractFactory {

    public abstract Phone getMiPhone();

    public abstract Phone getIPhone();

    public abstract Phone getHuaWeiPhone();

}
