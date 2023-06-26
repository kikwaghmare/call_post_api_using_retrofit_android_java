package com.example.testmyapp.api;

import com.example.testmyapp.models.LoginModel;
import com.example.testmyapp.models.SignUpModel;
import com.example.testmyapp.response.LoginResponse;
import com.example.testmyapp.response.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiCalls {

    //api for User SignUp
    @POST("api/BS/SaveUserRegistration")
    Call<SignUpResponse> createUser(@Body SignUpModel model);

    //api for User Login
    @POST("api/BS/UserLogin")
    Call<LoginResponse> loginUser(@Body LoginModel model);
}
