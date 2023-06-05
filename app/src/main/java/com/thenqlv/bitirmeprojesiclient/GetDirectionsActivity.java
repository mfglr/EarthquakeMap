package com.thenqlv.bitirmeprojesiclient;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.GsonBuilder;
import com.thenqlv.bitirmeprojesiclient.Adapters.GetDirectionsAdapter;
import com.thenqlv.bitirmeprojesiclient.Adapters.TextSearchAdapter;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Candidate;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Location;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.TextSearchModel;
import com.thenqlv.bitirmeprojesiclient.Services.Google.TextSerchService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetDirectionsActivity extends AppCompatActivity {
    private EditText editTextStartLocation;
    private EditText editTextEndLocation;
    private Location startLocation;
    private Location endLocation;
    private String currentMode;
    private String key = "AIzaSyAkDEFUmJmVRAl8GhpcIYZs5jl03VzaeCQ";
    private String baseUrl = Urls.GOOGLE_PLACE_API_URL;
    private RecyclerView recyclerView;
    private RadioButton driveRadioButton;
    private RadioButton walkRadioButton;
    private RadioButton transitRadioButton;
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
    private Retrofit retrofit;
    private void findsViewById(){
        editTextStartLocation = findViewById(R.id.editTextStartLocation);
        editTextEndLocation = findViewById(R.id.editTextEndLocation);
        driveRadioButton = findViewById(R.id.driveRadioButton);
        walkRadioButton = findViewById(R.id.walkRadioButton);
        transitRadioButton = findViewById(R.id.transitRadioButton);
        recyclerView = findViewById(R.id.routeRecyclerView);
    }
    private void initial(){
        findsViewById();
        driveRadioButton.setActivated(true);
        currentMode = "driving";
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_directions);
        initial();
        retrofit =  buildRetrofit(baseUrl);

        editTextStartLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TextSerchService service = retrofit.create(TextSerchService.class);
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
                                recyclerView.setLayoutManager(new LinearLayoutManager(GetDirectionsActivity.this));
                                recyclerView.setAdapter(
                                        new GetDirectionsAdapter(list,editTextStartLocation,"startLocation")
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

        editTextEndLocation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TextSerchService service = retrofit.create(TextSerchService.class);
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
                                recyclerView.setLayoutManager(new LinearLayoutManager(GetDirectionsActivity.this));
                                recyclerView.setAdapter(
                                        new GetDirectionsAdapter(list,editTextEndLocation,"endLocation")
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

    public void startMapsActivity(View view){
        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("startLocation",getIntent().getSerializableExtra("startLocation"));
        intent.putExtra("endLocation",getIntent().getSerializableExtra("endLocation"));
        intent.putExtra("mode",currentMode);
        startActivity(
                intent
        );
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.driveRadioButton:
                if (checked)
                    currentMode = "driving";
                    break;
            case R.id.walkRadioButton:
                if (checked)
                    currentMode = "walking";
                    break;
            case R.id.transitRadioButton:
                if (checked)
                    currentMode = "transit";
                break;
        }
    }
}