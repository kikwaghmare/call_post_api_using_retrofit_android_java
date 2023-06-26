package com.example.testmyapp.models;

import com.google.gson.annotations.SerializedName;

public class SignUpModel {

    @SerializedName("Name")
    private String name;
    @SerializedName("Mobile")
    private String mobile;
    @SerializedName("Email")
    private String email;
    @SerializedName("Password")
    private String password;
    @SerializedName("ConfirmPassword")
    private String confirmPassword;
    @SerializedName("Source")
    private String source;
    @SerializedName("IpAddress")
    private String ipAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
