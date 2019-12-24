package com.schoolTao.dto;

import java.util.Date;

public class CartDTO {

	private Integer cartId;
	
	private Integer userId;
	
	private Integer goodsId;

	private String goodsName;

	private Integer goodsOldPrice;
	
    private Integer goodsNewPrice;
    
    private String goodsPics;
    
    private String goodsUserName;
    
    private Byte goodsFresh;

    private Integer goodsNum;
    
    private String goodsState;

    private Integer cartGoodsNum;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
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

	public Byte getGoodsFresh() {
		return goodsFresh;
	}

	public void setGoodsFresh(Byte goodsFresh) {
		this.goodsFresh = goodsFresh;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(String goodsState) {
		this.goodsState = goodsState;
	}

	public Integer getCartGoodsNum() {
		return cartGoodsNum;
	}

	public void setCartGoodsNum(Integer cartGoodsNum) {
		this.cartGoodsNum = cartGoodsNum;
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
	

	public Integer getGoodsOldPrice() {
		return goodsOldPrice;
	}

	public void setGoodsOldPrice(Integer goodsOldPrice) {
		this.goodsOldPrice = goodsOldPrice;
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", userId=" + userId + ", goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsOldPrice=" + goodsOldPrice + ", goodsNewPrice=" + goodsNewPrice + ", goodsPics=" + goodsPics
				+ ", goodsUserName=" + goodsUserName + ", goodsFresh=" + goodsFresh + ", goodsNum=" + goodsNum
				+ ", goodsState=" + goodsState + ", cartGoodsNum=" + cartGoodsNum + "]";
	}
	
}
