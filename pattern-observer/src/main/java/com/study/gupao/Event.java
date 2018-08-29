package com.study.gupao;

import org.springframework.context.ApplicationEvent;

/**
 * 事件类
 *
 * @author 善变时光
 * @since 2018/6/26
 **/

public class Event extends ApplicationEvent{


    private String message;

    private Object source;

    public Event(Object source) {
        super(source);
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
