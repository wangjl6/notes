package com.gupao.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.SystemProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/6
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudServerApplication {

    public static void main(String[] args) {
        System.out.println(SystemProperties.get("user.dir"));
        SpringApplication application = new SpringApplication(SpringCloudServerApplication.class);
        application.run(args);
//        new SpringApplicationBuilder(SpringCloudServerApplication.class)
//                .web(WebApplicationType.SERVLET)
//                .run(args);
    }
}
