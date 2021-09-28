package com.jz.pojo;

public class User {

    private Integer id;
    private String userName;
    private String userPassword;
    private String userAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public User() {
    }

    public User(Integer id, String userName, String userPassword, String userAddress) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
    }
}
