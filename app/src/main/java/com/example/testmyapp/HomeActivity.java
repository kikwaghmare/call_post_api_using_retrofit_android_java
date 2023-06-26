package com.example.testmyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testmyapp.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding dashBoardBinding;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dashBoardBinding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(dashBoardBinding.getRoot());
        bundle=getIntent().getExtras();

        if(bundle!=null && bundle.containsKey("USERNAME")){
            dashBoardBinding.tvUserName.setText(bundle.getString("USERNAME"));
        }


    }
}