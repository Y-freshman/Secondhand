package com.schoolTao.pojo;

import java.util.Date;

public class Goods {
    private Integer goodsId;

    private Integer userId;

    private String goodsName;

    private Integer goodsOldPrice;

    private Integer goodsNewPrice;

    private Byte goodsFresh;

    private Integer goodsNum;

    private String goodsUserPhone;

    private String goodsUserName;

    private String goodsPics;

    private String goodsType;

    private Date goodsTime;

    private String goodsState;

    private Integer goodsViewNum;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsOldPrice() {
        return goodsOldPrice;
    }

    public void setGoodsOldPrice(Integer goodsOldPrice) {
        this.goodsOldPrice = goodsOldPrice;
    }

    public Integer getGoodsNewPrice() {
        return goodsNewPrice;
    }

    public void setGoodsNewPrice(Integer goodsNewPrice) {
        this.goodsNewPrice = goodsNewPrice;
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

    public String getGoodsUserPhone() {
        return goodsUserPhone;
    }

    public void setGoodsUserPhone(String goodsUserPhone) {
        this.goodsUserPhone = goodsUserPhone == null ? null : goodsUserPhone.trim();
    }

    public String getGoodsUserName() {
        return goodsUserName;
    }

    public void setGoodsUserName(String goodsUserName) {
        this.goodsUserName = goodsUserName == null ? null : goodsUserName.trim();
    }

    public String getGoodsPics() {
        return goodsPics;
    }

    public void setGoodsPics(String goodsPics) {
        this.goodsPics = goodsPics == null ? null : goodsPics.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public Date getGoodsTime() {
        return goodsTime;
    }

    public void setGoodsTime(Date goodsTime) {
        this.goodsTime = goodsTime;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState == null ? null : goodsState.trim();
    }

    public Integer getGoodsViewNum() {
        return goodsViewNum;
    }

    public void setGoodsViewNum(Integer goodsViewNum) {
        this.goodsViewNum = goodsViewNum;
    }

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", userId=" + userId + ", goodsName=" + goodsName + ", goodsOldPrice="
				+ goodsOldPrice + ", goodsNewPrice=" + goodsNewPrice + ", goodsFresh=" + goodsFresh + ", goodsNum="
				+ goodsNum + ", goodsUserPhone=" + goodsUserPhone + ", goodsUserName=" + goodsUserName + ", goodsPics="
				+ goodsPics + ", goodsType=" + goodsType + ", goodsTime=" + goodsTime + ", goodsState=" + goodsState
				+ ", goodsViewNum=" + goodsViewNum + "]";
	}
    
    
}