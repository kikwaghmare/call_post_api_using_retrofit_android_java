package com.example.testmyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testmyapp.databinding.ActivityMainBinding;
import com.example.testmyapp.models.SignUpModel;
import com.example.testmyapp.api.APIClient;
import com.example.testmyapp.api.ApiCalls;
import com.example.testmyapp.response.SignUpResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;


//    private Translator translatorGerman;
//    private Translator translatorArabic;
//    private Translator translatorKorean;
//
//    private Boolean booleanGerman = false;
//    private Boolean booleanArabic = false;
//    private Boolean booleanKorean = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validations();
            }
        });

        mainBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginActivity();
            }
        });



//        TranslatorOptions translatorOptionsArabic = new TranslatorOptions.Builder()
//                .setSourceLanguage(TranslateLanguage.ENGLISH)
//                .setTargetLanguage(TranslateLanguage.ARABIC)
//                .build();
//
//        translatorArabic = Translation.getClient(translatorOptionsArabic);
//        downloadModel();

    }

    private void Validations(){

        if(mainBinding.edtUName.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter UserName", Toast.LENGTH_SHORT).show();
        }else if(mainBinding.edtMobileNo.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter mobile no.", Toast.LENGTH_SHORT).show();
        }else if(mainBinding.edtEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter email id.", Toast.LENGTH_SHORT).show();
        }else if(mainBinding.edtPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter password.", Toast.LENGTH_SHORT).show();
        }else{
            SignUpUser();
        }
    }

    private void SignUpUser() {
        SignUpModel inputModel=new SignUpModel();
        inputModel.setName(mainBinding.edtUName.getText().toString());
        inputModel.setMobile(mainBinding.edtMobileNo.getText().toString());
        inputModel.setEmail(mainBinding.edtEmail.getText().toString());
        inputModel.setPassword(mainBinding.edtPassword.getText().toString());
        inputModel.setConfirmPassword(mainBinding.edtPassword.getText().toString());
        inputModel.setSource("ANDROID");
        inputModel.setIpAddress("::1");
        ApiCalls apiCalls= APIClient.getClient().create(ApiCalls.class);
        Call<SignUpResponse> call=apiCalls.createUser(inputModel);

        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (response.isSuccessful()){
                    SignUpResponse signUpResponse=response.body();

                    if(signUpResponse.getResponseCode().equals("2")){
                        Toast.makeText(MainActivity.this, signUpResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        goToLoginActivity();

                    }else{
                        Toast.makeText(MainActivity.this, signUpResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void goToLoginActivity() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }



//    private void downloadModel(){
//        DownloadConditions downloadConditions = new DownloadConditions.Builder()
//                .requireWifi()
//                .build();
//
//        translatorGerman.downloadModelIfNeeded(downloadConditions)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        booleanGerman = true;
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        booleanGerman = false;
//                    }
//                });
//
//        translatorArabic.downloadModelIfNeeded(downloadConditions)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        booleanArabic = true;
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        booleanArabic = false;
//                    }
//                });
//
//        translatorKorean.downloadModelIfNeeded(downloadConditions)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        booleanKorean = true;
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        booleanKorean = false;
//                    }
//                });
//    }

//    public void buttonDownloadModel(View view){
//        downloadModel();
//    }
//
//    public void buttonArabic(View view){
//
//        if (booleanGerman){
//            translatorArabic.translate(mainBinding.editText.getText().toString())
//                    .addOnSuccessListener(new OnSuccessListener<String>() {
//                        @Override
//                        public void onSuccess(String s) {
//                            mainBinding.textView.setText(s);
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            mainBinding.textView.setText(e.toString());
//                        }
//                    });
//        }
//    }

//    public void buttonKorean(View view){
//        if (booleanGerman){
//            translatorKorean.translate(mainBinding.edtMobileNo.getText().toString())
//                    .addOnSuccessListener(new OnSuccessListener<String>() {
//                        @Override
//                        public void onSuccess(String s) {
//                            mainBinding.edtMobileNo.setText(s);
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            mainBinding.edtMobileNo.setText(e.toString());
//                        }
//                    });
//        }
//    }
//
//    public void buttonGerman(View view){
//
//        if (booleanGerman){
//            translatorGerman.translate(mainBinding.edtMobileNo.getText().toString())
//                    .addOnSuccessListener(new OnSuccessListener<String>() {
//                        @Override
//                        public void onSuccess(String s) {
//                            mainBinding.edtMobileNo.setText(s);
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            mainBinding.edtMobileNo.setText(e.toString());
//                        }
//                    });
//        }
//    }

}