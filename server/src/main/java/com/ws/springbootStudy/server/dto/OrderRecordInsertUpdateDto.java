package com.ws.springbootStudy.server.dto;

/**
 * 用于接收界面传递的参数值
 * Created by UPC on 2019/1/5.
 */
public class OrderRecordInsertUpdateDto {

    private Integer id;

    private String orderNo;

    private String orderType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "OrderRecordInsertUpdateDto{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
