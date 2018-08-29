package com.study.gupao;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件监听类
 *
 * @author 善变时光
 * @since 2018/6/26
 **/
@Component("eventListener")
public class EventListener{

    @Async
    @org.springframework.context.event.EventListener
    public void notifyEvent(Event event){
        System.out.println(event.getMessage());
        System.out.println("线程为："+Thread.currentThread().getName());
    }
}
