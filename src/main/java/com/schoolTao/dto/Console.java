package com.schoolTao.dto;

import java.util.Date;

public class Console {

	private Integer num;

	private String goodsType;
	
	private Date orderTime;

	private String userSex;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Override
	public String toString() {
		return "Console [num=" + num + ", goodsType=" + goodsType + ", orderTime=" + orderTime + ", userSex=" + userSex
				+ "]";
	}

	
	
	

	
}
