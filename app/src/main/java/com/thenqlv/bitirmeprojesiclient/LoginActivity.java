package com.thenqlv.bitirmeprojesiclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.GsonBuilder;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Individual;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Parent;
import com.thenqlv.bitirmeprojesiclient.Entities.API.User;
import com.thenqlv.bitirmeprojesiclient.Services.API.IndividualService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {


    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonSingIn;

    private TextView textViewControl;
    private Retrofit retrofit;
    private String baseUrl = Urls.APP_API_URL;

    private Retrofit buildRetrofit(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(
                        GsonConverterFactory.create(
                                new GsonBuilder()
                                        .setLenient()
                                        .create()
                        )
                )
                .build();
    }

    private void findsViewById(){
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSingIn = findViewById(R.id.buttonSingIn);
        textViewControl = findViewById(R.id.textViewControl);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findsViewById();

        retrofit = buildRetrofit(baseUrl);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                IndividualService service = retrofit.create(IndividualService.class);
                Call<Parent<Individual>> result = null;
                if(username.equals("") || password.equals("")){
                    textViewControl.setText("Lütfen eksik bilgi girmeyiniz!");
                }
                else {
                    result = service.getWithDiseasesWithProductsByUsername(username);
                    result.enqueue(new Callback<Parent<Individual>>() {
                        @Override
                        public void onResponse(Call<Parent<Individual>> call, Response<Parent<Individual>> response) {
                            if (response.isSuccessful()) {
                                Individual individual = response.body().getData();
                                if(individual != null){
                                    if(individual.getPassword().equals(password)){
                                        startActivity(
                                                new Intent(
                                                        LoginActivity.
                                                                this,MapsActivity.class
                                                ).putExtra("individual",individual)
                                        );
                                        System.out.println(individual.getDiseases().get(0).getProducts().get(0).getId());
                                    }
                                    else{
                                        textViewControl.setText("Hatalı giriş");
                                    }
                                }
                                else{
                                    textViewControl.setText("Kullanıcı Tanınlı Değil!!!");
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Parent<Individual>> call, Throwable t) {
                            System.out.println(t);
                        }
                    });

                }
            }
        });
    }
}