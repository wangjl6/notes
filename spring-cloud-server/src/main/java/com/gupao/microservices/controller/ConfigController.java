package com.gupao.microservices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/6
 **/
@RestController
public class ConfigController {

    @Value("${myName}")
    private String myName;


    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello "+myName;
    }
}
