package com.gupao.microservices.springboot.controller;

import com.gupao.microservices.springboot.annotation.MyBean;
import com.gupao.microservices.springboot.annotation.MyGetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/13
 **/
@MyBean
@RestController
public class TestController {


    @MyGetMapping("/say")
    public String say(){
        return "Hello World";
    }
}
