package com.lovejava.domain;

/**
 * @author:tianyao
 * @date:2019-04-02 21:09
 */
public class UserMistake {
    private Integer userId;
    private String username;
    private String userBirthday;
    private String userSex;
    private String userAddress;

    @Override
    public String toString() {
        return "UserMistake{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
