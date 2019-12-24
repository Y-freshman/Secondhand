package com.schoolTao.pojo;

import java.util.Date;

public class Notice {
    private Integer noticeId;

    private Integer userId;

    private String noticeContent;

    private Date noticeTime;

    private String noticeType;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", userId=" + userId + ", noticeContent=" + noticeContent
				+ ", noticeTime=" + noticeTime + ", noticeType=" + noticeType + "]";
	}
    
    
}