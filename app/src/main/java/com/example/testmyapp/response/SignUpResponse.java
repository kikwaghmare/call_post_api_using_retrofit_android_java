package com.example.testmyapp.response;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {

    @SerializedName("ResponseCode")
     
    private String responseCode;
    @SerializedName("Message")
     
    private String message;
    @SerializedName("RedirectUrl")
     
    private String redirectUrl;
    @SerializedName("Attribute1")
     
    private String attribute1;
    @SerializedName("TrackId")
     
    private Object trackId;

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

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public Object getTrackId() {
        return trackId;
    }

    public void setTrackId(Object trackId) {
        this.trackId = trackId;
    }
}
