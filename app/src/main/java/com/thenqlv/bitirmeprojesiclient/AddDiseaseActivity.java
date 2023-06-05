package com.thenqlv.bitirmeprojesiclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.thenqlv.bitirmeprojesiclient.Adapters.SearchDiseaseAdapter;
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

public class AddDiseaseActivity extends AppCompatActivity {
    private EditText editTextSearchDisease;
    private Button addDiseaseButton;
    private RecyclerView recyclerView;
    private Individual individual;
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
    private void findsById(){
        editTextSearchDisease = findViewById(R.id.editTextTextSearchDisease);
        addDiseaseButton = findViewById(R.id.addDiseaseButton);
        recyclerView = findViewById(R.id.recyclerViewSearchDisease);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_disease);
        findsById();
        individual = (Individual) getIntent().getSerializableExtra("individual");
        editTextSearchDisease.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buildRetrofit(Urls.APP_API_URL)
                        .create(DiseaseService.class)
                        .getByName(editTextSearchDisease.getText().toString())
                        .enqueue(new Callback<Parent<List<Disease>>>() {
                            @Override
                            public void onResponse(Call<Parent<List<Disease>>> call, Response<Parent<List<Disease>>> response) {
                                if(response != null && response.body() != null) {
                                    List<Disease> list = response.body().getData();
                                    if (list != null) {
                                        SearchDiseaseAdapter adapter = new SearchDiseaseAdapter(
                                                list,
                                                editTextSearchDisease,
                                                AddDiseaseActivity.this
                                        );
                                        recyclerView.setLayoutManager(new LinearLayoutManager(AddDiseaseActivity.this));
                                        recyclerView.setAdapter(adapter);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<Parent<List<Disease>>> call, Throwable t) {

                            }
                        });


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        addDiseaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disease disease = (Disease) getIntent().getSerializableExtra("disease");
                if(disease != null){
                    buildRetrofit(Urls.APP_API_URL)
                            .create(IndividualService.class)
                            .addDiseaseById(individual.getId(),disease)
                            .enqueue(new Callback<Parent<Individual>>() {
                                @Override
                                public void onResponse(Call<Parent<Individual>> call, Response<Parent<Individual>> response) {
                                    Toast.makeText(AddDiseaseActivity.this,"Basarili",Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onFailure(Call<Parent<Individual>> call, Throwable t) {
                                    Toast.makeText(AddDiseaseActivity.this,"Basarisiz",Toast.LENGTH_LONG).show();
                                }
                            });
                }
            }
        });
    }
}