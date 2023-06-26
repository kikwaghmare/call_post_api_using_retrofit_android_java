package com.example.testmyapp.models;

import com.google.gson.annotations.SerializedName;

public class LoginModel {


    @SerializedName("Email")
    private String email;
    @SerializedName("Password")
    private String password;
    @SerializedName("CultureId")
    private int cultureId;

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

    public int getCultureId() {
        return cultureId;
    }

    public void setCultureId(int cultureId) {
        this.cultureId = cultureId;
    }


}
