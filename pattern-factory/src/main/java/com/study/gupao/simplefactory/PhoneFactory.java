package com.study.gupao.simplefactory;

import com.study.gupao.*;

/**
 * 手机工厂
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public class PhoneFactory{

    public Phone productionPhone(String type) {
        switch (type){
            case "小米":
                return new MiPhone();
            case "华为":
                return new HuaWeiPhone();
            case "苹果":
                return new IPhone();
            default:
                return null;
        }
    }
}
