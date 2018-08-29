package com.gupao.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * spring cloud 配置服务
 *
 * @author BigWang
 * @createTime 2018/8/5
 **/
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication application =
                new SpringApplication(SpringCloudConfigServerApplication.class);
        application.run(args);

    }
}
