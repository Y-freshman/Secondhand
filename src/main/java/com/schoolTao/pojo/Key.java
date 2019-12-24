package com.schoolTao.pojo;

import java.util.Date;

public class Key {
    private Integer keyId;

    private Integer userId;

    private String keyContent;

    private Date keyTime;

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getKeyContent() {
        return keyContent;
    }

    public void setKeyContent(String keyContent) {
        this.keyContent = keyContent == null ? null : keyContent.trim();
    }

    public Date getKeyTime() {
        return keyTime;
    }

    public void setKeyTime(Date keyTime) {
        this.keyTime = keyTime;
    }

	@Override
	public String toString() {
		return "Key [keyId=" + keyId + ", userId=" + userId + ", keyContent=" + keyContent + ", keyTime=" + keyTime
				+ "]";
	}
    
    
}