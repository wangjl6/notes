package com.study.gupao.api.impl;

import com.study.gupao.api.IUserService;

/**
 * 用户接口实现
 *
 * @author 善变时光
 * @since 2018/7/1
 **/
public class UserServiceImpl implements IUserService{
    @Override
    public String getUsername() {
        return "admin";
    }
}
