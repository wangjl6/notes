package com.study.gupao;

/**
 * 工厂接口类
 *
 * @author 善变时光
 * @since 2018/4/1
 **/
public interface Factory {

    /**
     * 生产手机接口方法
     * @return {@link Phone}
     */
    Phone productionPhone();
}
