package com.study.gupao.dto;

import java.io.Serializable;

/**
 * 响应实体
 *
 * @author 善变时光
 * @since 2018/7/1
 **/
public class ResponseBody implements Serializable {

    private String message;

    private String code;

    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ResponseBody{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
