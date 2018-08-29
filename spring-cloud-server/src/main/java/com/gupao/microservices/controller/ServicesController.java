package com.gupao.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 注释.....
 *
 * @author BigWang
 * @createTime 2018/8/8
 **/
@RestController
public class ServicesController {

    @Autowired
    DiscoveryClient discoveryClient;


    @GetMapping("/services")
    public List<String> getServices(){
        return discoveryClient.getServices();
    }

    @GetMapping("/serviceInstances")
    public List<ServiceInstance> getServiceInstances(){
        List<ServiceInstance> serviceInstances = new ArrayList<>();
        discoveryClient.getServices().stream().forEach(service->{
            serviceInstances.addAll(discoveryClient.getInstances(service));
        });
        return serviceInstances;
    }
}
