package com.schoolTao.pojo;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer userId;
    private String userName;
    private String userSex;
    private String userAvater;
    private String userVip;
    private Integer needId;

    private String commentContent;

    private Date commentTime;

    private Integer commentLikeNum;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNeedId() {
        return needId;
    }

    public void setNeedId(Integer needId) {
        this.needId = needId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentLikeNum() {
        return commentLikeNum;
    }

    public void setCommentLikeNum(Integer commentLikeNum) {
        this.commentLikeNum = commentLikeNum;
    }
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserVip() {
		return userVip;
	}

	public void setUserVip(String userVip) {
		this.userVip = userVip;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", userName=" + userName + ", userSex="
				+ userSex + ", userAvater=" + userAvater + ", userVip=" + userVip + ", needId=" + needId
				+ ", commentContent=" + commentContent + ", commentTime=" + commentTime + ", commentLikeNum="
				+ commentLikeNum + "]";
	}

	
    
}