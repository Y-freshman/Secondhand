package com.schoolTao.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userSex;

    private String userIntro;

    private String userAvater;

    private Date userRegisterTime;

    private String userMibao;

    private String userAnswer;

    private Integer userRemainNum;

    private Integer userPurchaseNum;

    private String userVip;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro == null ? null : userIntro.trim();
    }

    public String getUserAvater() {
        return userAvater;
    }

    public void setUserAvater(String userAvater) {
        this.userAvater = userAvater == null ? null : userAvater.trim();
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public String getUserMibao() {
        return userMibao;
    }

    public void setUserMibao(String userMibao) {
        this.userMibao = userMibao == null ? null : userMibao.trim();
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer == null ? null : userAnswer.trim();
    }

    public Integer getUserRemainNum() {
        return userRemainNum;
    }

    public void setUserRemainNum(Integer userRemainNum) {
        this.userRemainNum = userRemainNum;
    }

    public Integer getUserPurchaseNum() {
        return userPurchaseNum;
    }

    public void setUserPurchaseNum(Integer userPurchaseNum) {
        this.userPurchaseNum = userPurchaseNum;
    }

    public String getUserVip() {
        return userVip;
    }

    public void setUserVip(String userVip) {
        this.userVip = userVip == null ? null : userVip.trim();
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userSex="
				+ userSex + ", userIntro=" + userIntro + ", userAvater=" + userAvater + ", userRegisterTime="
				+ userRegisterTime + ", userMibao=" + userMibao + ", userAnswer=" + userAnswer + ", userRemainNum="
				+ userRemainNum + ", userPurchaseNum=" + userPurchaseNum + ", userVip=" + userVip + "]";
	}
    
    
}