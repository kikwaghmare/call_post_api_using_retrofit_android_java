package com.example.testmyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.testmyapp.databinding.ActivityLoginBinding;
import com.example.testmyapp.models.LoginModel;
import com.example.testmyapp.api.APIClient;
import com.example.testmyapp.api.ApiCalls;
import com.example.testmyapp.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v ->{

                Validations();
        });

        binding.tvSignUp.setOnClickListener(v ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }


    private void Validations(){

        if(binding.edtUserName.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter UserName", Toast.LENGTH_SHORT).show();
        }else if(binding.edtPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter password.", Toast.LENGTH_SHORT).show();
        }else{
            LoginUser();
        }
    }
    private void LoginUser() {
        LoginModel inputModel=new LoginModel();
        inputModel.setEmail(binding.edtUserName.getText().toString());
        inputModel.setPassword(binding.edtPassword.getText().toString());
        inputModel.setCultureId(1);
        ApiCalls apiCalls= APIClient.getClient().create(ApiCalls.class);
        Call<LoginResponse> call=apiCalls.loginUser(inputModel);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    LoginResponse loginResponse=response.body();
                    if(loginResponse.getResponseCode().equals("2")){
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        goToDashBoard(loginResponse.getUserDetails().getName());

                    }else {
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void goToDashBoard(String name) {

        Intent intent=new Intent(this, HomeActivity.class);
        intent.putExtra("USERNAME", name);
        startActivity(intent);
        finishAffinity();

    }
}