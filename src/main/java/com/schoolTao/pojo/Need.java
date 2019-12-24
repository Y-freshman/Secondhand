package com.schoolTao.pojo;

import java.util.Date;

public class Need {
    private Integer needId;

    private Integer userId;
    private String userName;
    private String userSex;
    private String userAvater;
    private String userVip;

    private String needContent;

    private String needPics;

    private Integer needViewNum;

    private Date needTime;

    private Integer needCommentNum;

    public Integer getNeedId() {
        return needId;
    }

    public void setNeedId(Integer needId) {
        this.needId = needId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNeedContent() {
        return needContent;
    }

    public void setNeedContent(String needContent) {
        this.needContent = needContent == null ? null : needContent.trim();
    }

    public String getNeedPics() {
        return needPics;
    }

    public void setNeedPics(String needPics) {
        this.needPics = needPics == null ? null : needPics.trim();
    }

    public Integer getNeedViewNum() {
        return needViewNum;
    }

    public void setNeedViewNum(Integer needViewNum) {
        this.needViewNum = needViewNum;
    }

    public Date getNeedTime() {
        return needTime;
    }

    public void setNeedTime(Date needTime) {
        this.needTime = needTime;
    }

    public Integer getNeedCommentNum() {
        return needCommentNum;
    }

    public void setNeedCommentNum(Integer needCommentNum) {
        this.needCommentNum = needCommentNum;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public String getUserAvater() {
		return userAvater;
	}

	public void setUserAvater(String userAvater) {
		this.userAvater = userAvater;
	}

	

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserVip() {
		return userVip;
	}

	public void setUserVip(String userVip) {
		this.userVip = userVip;
	}

	@Override
	public String toString() {
		return "Need [needId=" + needId + ", userId=" + userId + ", userName=" + userName + ", userSex=" + userSex
				+ ", userAvater=" + userAvater + ", userVip=" + userVip + ", needContent=" + needContent + ", needPics="
				+ needPics + ", needViewNum=" + needViewNum + ", needTime=" + needTime + ", needCommentNum="
				+ needCommentNum + "]";
	}

	
    
}