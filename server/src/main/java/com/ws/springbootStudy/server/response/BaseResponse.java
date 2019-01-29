package com.ws.springbootStudy.server.response;

import com.ws.springbootStudy.server.enums.StatusCode;

/**
 * 通用的响应体，包含：
 * 1、响应编码：code
 * 2、响应消息：msg
 * 3、响应的数据 data
 * Created by UPC on 2019/1/5.
 */
public class BaseResponse<T> {

    private Integer code;
    private String message;
    private T data;

    public BaseResponse(T data, StatusCode statusCode) {
        this.data = data;
        this.code=statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
