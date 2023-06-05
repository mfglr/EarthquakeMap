package com.thenqlv.bitirmeprojesiclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.GsonBuilder;
import com.thenqlv.bitirmeprojesiclient.Adapters.DiseasesAdapter;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Address;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Disease;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Individual;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Parent;
import com.thenqlv.bitirmeprojesiclient.Services.API.DiseaseService;
import com.thenqlv.bitirmeprojesiclient.Services.API.IndividualService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfilActivity extends AppCompatActivity {

    private EditText name;
    private EditText lastName;
    private EditText username;
    private RecyclerView diseasesRecyclerView;
    private Button buttonAddDiseas;

    private Individual individual;

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
        name = findViewById(R.id.name);
        lastName = findViewById(R.id.lastName);
        username = findViewById(R.id.username);
        diseasesRecyclerView = findViewById(R.id.diseasesRecyclerView);
        buttonAddDiseas = findViewById(R.id.buttonAddDisease);
    }

    private void setInformations(Individual individual){
        name.setText(individual.getName());
        name.setEnabled(false);
        username.setText(individual.getUsername());
        username.setEnabled(false);
        lastName.setText(individual.getLastname());
        lastName.setEnabled(false);
    }
    private void setDiseasesRecyclerView(int id){
        buildRetrofit(Urls.APP_API_URL)
                .create(IndividualService.class)
                .getWithDiseasesById(individual.getId())
                .enqueue(new Callback<Parent<Individual>>() {
                    @Override
                    public void onResponse(Call<Parent<Individual>> call, Response<Parent<Individual>> response) {
                        if(response != null && response.body() != null) {
                            List<Disease> diseases = response.body().getData().getDiseases();
                            DiseasesAdapter diseasesAdapter = new DiseasesAdapter(diseases);
                            diseasesRecyclerView.setLayoutManager(new LinearLayoutManager(ProfilActivity.this));
                            diseasesRecyclerView.setAdapter(diseasesAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<Parent<Individual>> call, Throwable t) {

                    }
                });



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        findsViewById();
        individual = (Individual) getIntent().getSerializableExtra("individual");
        setInformations(individual);
        setDiseasesRecyclerView(individual.getId());
        buttonAddDiseas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(ProfilActivity.this, AddDiseaseActivity.class)
                                .putExtra("individual",individual)
                );
            }
        });
    }
}