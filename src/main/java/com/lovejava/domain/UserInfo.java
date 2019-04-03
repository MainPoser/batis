package com.lovejava.domain;

/**
 * @author:tianyao
 * @date:2019-04-02 20:49
 */
public class UserInfo {
    private User user;

    @Override
    public String toString() {
        return "UserInfo{" +
                "user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
