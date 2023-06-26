package com.example.testmyapp.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {


    @SerializedName("ResponseCode")

    private String responseCode;
    @SerializedName("Message")

    private String message;
    @SerializedName("RedirectUrl")

    private String redirectUrl;
    @SerializedName("Attribute1")

    private Object attribute1;
    @SerializedName("UserDetails")

    private UserDetails userDetails;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Object getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(Object attribute1) {
        this.attribute1 = attribute1;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }



    public class UserDetails {

        @SerializedName("UserId")

        private int userId;
        @SerializedName("Name")

        private String name;
        @SerializedName("Mobile")

        private String mobile;
        @SerializedName("Email")

        private String email;
        @SerializedName("IsShow_Dashboard")

        private boolean isShowDashboard;
        @SerializedName("IsEmail_Dummy")

        private boolean isEmailDummy;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

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

        public boolean isIsShowDashboard() {
            return isShowDashboard;
        }

        public void setIsShowDashboard(boolean isShowDashboard) {
            this.isShowDashboard = isShowDashboard;
        }

        public boolean isIsEmailDummy() {
            return isEmailDummy;
        }

        public void setIsEmailDummy(boolean isEmailDummy) {
            this.isEmailDummy = isEmailDummy;
        }

    }
}
