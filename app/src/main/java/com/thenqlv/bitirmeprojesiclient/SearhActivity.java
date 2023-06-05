package com.thenqlv.bitirmeprojesiclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.gms.maps.GoogleMap;
import com.google.gson.GsonBuilder;
import com.thenqlv.bitirmeprojesiclient.Adapters.TextSearchAdapter;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Individual;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Candidate;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.TextSearchModel;
import com.thenqlv.bitirmeprojesiclient.Services.Google.TextSerchService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearhActivity extends AppCompatActivity {

    private String key = "AIzaSyAkDEFUmJmVRAl8GhpcIYZs5jl03VzaeCQ";
    private GoogleMap googleMap;
    private EditText searchEditText;
    private RecyclerView recyclerView;
    private Retrofit retrofitPlace;
    private String baseUrl = Urls.GOOGLE_PLACE_API_URL;
    private void FindsViewById(){
        searchEditText = findViewById(R.id.editTextSearch);
        recyclerView = findViewById(R.id.recyclerViewSearch);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searh);
        FindsViewById();
        retrofitPlace = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(
                        GsonConverterFactory.create(
                                new GsonBuilder()
                                        .setLenient()
                                        .create()
                        )
                )
                .build();

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TextSerchService service = retrofitPlace.create(TextSerchService.class);
                Map<String,String> options = new HashMap<String,String>();
                String query = String.valueOf(charSequence);
                options.put("query",query);
                options.put("key",key);
                Call<TextSearchModel> result = service.get(options);

                result.enqueue(new Callback<TextSearchModel>() {
                    @Override
                    public void onResponse(Call<TextSearchModel> call, Response<TextSearchModel> response) {
                        if(response.isSuccessful()){
                            Candidate[] list = response.body().getResults();
                            if(list == null)
                                System.out.println("null");
                            else {
                                recyclerView.setLayoutManager(new LinearLayoutManager(SearhActivity.this));
                                recyclerView.setAdapter(
                                        new TextSearchAdapter(
                                                list,
                                                (Individual) getIntent().getSerializableExtra("individual")
                                        )
                                );
                            }
                        }
                        else{
                            System.out.println("basarisiz");
                        }
                    }

                    @Override
                    public void onFailure(Call<TextSearchModel> call, Throwable t) {

                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}