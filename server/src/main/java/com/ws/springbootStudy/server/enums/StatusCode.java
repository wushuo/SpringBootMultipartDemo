package com.ws.springbootStudy.server.enums;

/**
 * 自定义的响应编码和响应消息的枚举信息
 * Created by UPC on 2019/1/5.
 */
public enum StatusCode {

    SUCCESS("处理成功",20),
    FAIL("处理失败",50),
    NOTFOUND("页面不存在",40),
    NOT_EXIST_ENTITY("数据不存在",10011);

    private Integer code;
    private String message;

    StatusCode(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
