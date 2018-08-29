package com.gupao.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 注册中心
 *
 * @author BigWang
 * @createTime 2018/8/7
 **/
@SpringBootApplication
public class SpringCloudRegistryApplication {

    public static void main(String[] args) {
        SpringApplication springApplication =
                new SpringApplication(SpringCloudRegistryApplication.class);
        springApplication.run(args);
    }
}
