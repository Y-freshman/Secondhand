package com.schoolTao.pojo;

import java.util.Date;

public class Cart {
    private Integer cartId;

    private Integer userId;

    private Integer goodsId;

    private Date cartTime;

    private Integer cartGoodsNum;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public Date getCartTime() {
        return cartTime;
    }

    public void setCartTime(Date cartTime) {
        this.cartTime = cartTime;
    }

    public Integer getCartGoodsNum() {
        return cartGoodsNum;
    }

    public void setCartGoodsNum(Integer cartGoodsNum) {
        this.cartGoodsNum = cartGoodsNum;
    }

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", goodsId=" + goodsId + ", cartTime=" + cartTime
				+ ", cartGoodsNum=" + cartGoodsNum + "]";
	}
    
    
}