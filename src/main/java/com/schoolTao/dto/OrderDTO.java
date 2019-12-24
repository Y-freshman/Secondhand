package com.schoolTao.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {

	private Integer orderId;

    private Integer userId;

    private Integer goodsId;

    private Date orderTime;

    private Integer orderNum;

    private String orderState;
    
    private String goodsName;

    private Integer goodsNewPrice;
    
    private String goodsPics;
    
    private String goodsUserName;
    
    
    
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
		this.orderState = orderState;
	}



	public String getGoodsName() {
		return goodsName;
	}



	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}



	public Integer getGoodsNewPrice() {
		return goodsNewPrice;
	}



	public void setGoodsNewPrice(Integer goodsNewPrice) {
		this.goodsNewPrice = goodsNewPrice;
	}



	public String getGoodsPics() {
		return goodsPics;
	}



	public void setGoodsPics(String goodsPics) {
		this.goodsPics = goodsPics;
	}



	public String getGoodsUserName() {
		return goodsUserName;
	}



	public void setGoodsUserName(String goodsUserName) {
		this.goodsUserName = goodsUserName;
	}



	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", userId=" + userId + ", goodsId=" + goodsId + ", orderTime="
				+ orderTime + ", orderNum=" + orderNum + ", orderState=" + orderState + ", goodsName=" + goodsName
				+ ", goodsNewPrice=" + goodsNewPrice + ", goodsPics=" + goodsPics + ", goodsUserName=" + goodsUserName
				+ "]";
	}
    
}
