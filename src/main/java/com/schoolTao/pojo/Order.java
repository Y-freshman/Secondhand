package com.schoolTao.pojo;

import java.util.Date;

public class Order {
    private Integer orderId;

    private Integer userId;

    private Integer goodsId;

    private Date orderTime;

    private Integer orderNum;

    private String orderState;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", goodsId=" + goodsId + ", orderTime=" + orderTime
				+ ", orderNum=" + orderNum + ", orderState=" + orderState + "]";
	}
    
}