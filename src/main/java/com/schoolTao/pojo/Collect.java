package com.schoolTao.pojo;

import java.util.Date;

public class Collect {
    private Integer collectId;

    private Integer goodsId;

    private Integer userId;

    private Date collectTime;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

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

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

	@Override
	public String toString() {
		return "Collect [collectId=" + collectId + ", goodsId=" + goodsId + ", userId=" + userId + ", collectTime="
				+ collectTime + "]";
	}
    
    
}