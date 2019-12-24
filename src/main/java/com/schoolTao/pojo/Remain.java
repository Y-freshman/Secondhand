package com.schoolTao.pojo;

import java.util.Date;

public class Remain {
    private Integer remainId;

    private Integer userId;

    private String remainContent;

    private Date remainTime;

    private Integer remainToId;

    private Integer remianLastId;

    public Integer getRemainId() {
        return remainId;
    }

    public void setRemainId(Integer remainId) {
        this.remainId = remainId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemainContent() {
        return remainContent;
    }

    public void setRemainContent(String remainContent) {
        this.remainContent = remainContent == null ? null : remainContent.trim();
    }

    public Date getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(Date remainTime) {
        this.remainTime = remainTime;
    }

    public Integer getRemainToId() {
        return remainToId;
    }

    public void setRemainToId(Integer remainToId) {
        this.remainToId = remainToId;
    }

    public Integer getRemianLastId() {
        return remianLastId;
    }

    public void setRemianLastId(Integer remianLastId) {
        this.remianLastId = remianLastId;
    }

	@Override
	public String toString() {
		return "Remain [remainId=" + remainId + ", userId=" + userId + ", remainContent=" + remainContent
				+ ", remainTime=" + remainTime + ", remainToId=" + remainToId + ", remianLastId=" + remianLastId + "]";
	}
    
    
}