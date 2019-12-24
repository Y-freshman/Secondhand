package com.schoolTao.pojo;

import java.util.Date;

public class Turn {
    private Integer turnId;

    private Integer goodsId;

    private String turnPic;

    private String turnContent;

    private Date turnTime;

    public Integer getTurnId() {
        return turnId;
    }

    public void setTurnId(Integer turnId) {
        this.turnId = turnId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getTurnPic() {
        return turnPic;
    }

    public void setTurnPic(String turnPic) {
        this.turnPic = turnPic == null ? null : turnPic.trim();
    }

    public String getTurnContent() {
        return turnContent;
    }

    public void setTurnContent(String turnContent) {
        this.turnContent = turnContent == null ? null : turnContent.trim();
    }

    public Date getTurnTime() {
        return turnTime;
    }

    public void setTurnTime(Date turnTime) {
        this.turnTime = turnTime;
    }

	@Override
	public String toString() {
		return "Turn [turnId=" + turnId + ", goodsId=" + goodsId + ", turnPic=" + turnPic + ", turnContent="
				+ turnContent + ", turnTime=" + turnTime + "]";
	}
    
    
}