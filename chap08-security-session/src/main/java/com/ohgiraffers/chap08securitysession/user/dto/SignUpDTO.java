package com.ohgiraffers.chap08securitysession.user.dto;

public class SignUpDTO {

    private String userId;
    private String username;
    private String userPass;
    private String role;

    public SignUpDTO() {
    }

    public SignUpDTO(String userId, String username, String userPass, String role) {
        this.userId = userId;
        this.username = username;
        this.userPass = userPass;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", userPass='" + userPass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
