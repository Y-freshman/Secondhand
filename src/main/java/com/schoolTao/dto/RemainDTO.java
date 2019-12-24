package com.schoolTao.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemainDTO {

	private Integer remainId;

    private Integer userId;
    
    private String userSex;
    
    private String userAvater;

    private String userName;
    
    private Integer receicverId;
    
    private String remainContent;

    private Date remainTime;

    private Integer remianLastId;
    
    private List<RemainDTO> subContent;
    
	public List<RemainDTO> getSubContent() {
		return subContent;
	}

	public void setSubContent(List<RemainDTO> subContent) {
		this.subContent = subContent;
	}

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

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAvater() {
		return userAvater;
	}

	public void setUserAvater(String userAvater) {
		this.userAvater = userAvater;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getReceicverId() {
		return receicverId;
	}

	public void setReceicverId(Integer receicverId) {
		this.receicverId = receicverId;
	}

	public String getRemainContent() {
		return remainContent;
	}

	public void setRemainContent(String remainContent) {
		this.remainContent = remainContent;
	}

	public Date getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(Date remainTime) {
		this.remainTime = remainTime;
	}

	public Integer getRemianLastId() {
		return remianLastId;
	}

	public void setRemianLastId(Integer remianLastId) {
		this.remianLastId = remianLastId;
	}

	@Override
	public String toString() {
		return "RemainDTO [remainId=" + remainId + ", userId=" + userId + ", userSex=" + userSex + ", userAvater="
				+ userAvater + ", userName=" + userName + ", receicverId=" + receicverId + ", remainContent="
				+ remainContent + ", remainTime=" + remainTime + ", remianLastId=" + remianLastId + ", subContent="
				+ subContent + "]";
	}
	
}
