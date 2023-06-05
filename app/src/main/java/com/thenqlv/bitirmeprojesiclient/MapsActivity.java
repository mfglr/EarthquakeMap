package com.thenqlv.bitirmeprojesiclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.GsonBuilder;
import com.google.maps.android.PolyUtil;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Address;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Business;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Disease;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Individual;
import com.thenqlv.bitirmeprojesiclient.Entities.API.MusterPoint;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Parent;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Product;
import com.thenqlv.bitirmeprojesiclient.Entities.Afad.Earthquake;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Candidate;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.DirectionsModel;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Location;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Route;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Viewport;
import com.thenqlv.bitirmeprojesiclient.Filters.EarthquakeFilter;
import com.thenqlv.bitirmeprojesiclient.Services.API.AddressService;
import com.thenqlv.bitirmeprojesiclient.Services.API.MusterPointService;
import com.thenqlv.bitirmeprojesiclient.Services.Afad.EarthquakeService;
import com.thenqlv.bitirmeprojesiclient.Services.Google.DirectionsService;
import com.thenqlv.bitirmeprojesiclient.databinding.ActivityMapsBinding;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Candidate candidate = null;
    private EarthquakeFilter filter = null;
    private Earthquake earthquake = null;
    private Individual individual = null;
    private Location currentLocation = null;
    private String key = "AIzaSyAkDEFUmJmVRAl8GhpcIYZs5jl03VzaeCQ";

    private Location startLocation = null;
    private Location endLocation = null;
    private String mode = null;
    private ActivityMapsBinding binding;

    private String baseUrlDirections = Urls.GOOGLE_DIRECTIONS_API_URL;


    private Retrofit retrofitDirections;
    private FloatingActionButton searchFloatActionButton;
    private FloatingActionButton earthquakeFilterFloatActionButton;







    private void showPoint(LatLng point){
        mMap.addMarker(
                new MarkerOptions().position(
                        point
                )
        );
        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(point,15)
        );
    }
    private void showPointsOnTheMap(LatLng[] points){
        for(int i = 0; i < points.length;i++) {
            mMap.addMarker(
                    new MarkerOptions().position(
                            points[i]
                    )
            );
        }
        mMap.moveCamera(
                CameraUpdateFactory.newLatLngBounds(
                        Compute.findTheBounds(points),150
                )
        );
    }


    private BitmapDescriptor getBitmapDescriptor(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            VectorDrawable vectorDrawable = (VectorDrawable) getDrawable(id);

            int h = vectorDrawable.getIntrinsicHeight();
            int w = vectorDrawable.getIntrinsicWidth();

            vectorDrawable.setBounds(0, 0, w, h);

            Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bm);
            vectorDrawable.draw(canvas);

            return BitmapDescriptorFactory.fromBitmap(bm);

        } else {
            return BitmapDescriptorFactory.fromResource(id);
        }
    }
    private void showTheEartquake(Earthquake eartquke){
        LatLng point = eartquke.getLatLng();
        mMap.addMarker(
                new MarkerOptions()
                        .position(point)
        ).setIcon(getBitmapDescriptor(R.drawable.danger));
        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(point,15)
        );
    }
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        candidate = (Candidate) getIntent().getSerializableExtra("candidate");
        filter = (EarthquakeFilter) getIntent().getSerializableExtra("filter");
        startLocation = (Location) getIntent().getSerializableExtra("startLocation");
        endLocation = (Location) getIntent().getSerializableExtra("endLocation");
        mode = getIntent().getStringExtra("mode");
        earthquake = (Earthquake) getIntent().getSerializableExtra("earthquake");
        currentLocation = (Location) getIntent().getSerializableExtra("currentLocation");
        individual = (Individual) getIntent().getSerializableExtra("individual");
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        retrofitDirections = buildRetrofit(baseUrlDirections);

        searchFloatActionButton = findViewById(R.id.floatingActionButtonSearch);
        earthquakeFilterFloatActionButton = findViewById(R.id.floatingActionButtonEartquakeFilter);


        startService(
                new Intent(this, EarthquakeIntentService.class)
        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem){
        if(menuItem.getItemId() == R.id.profilItem){
            startActivity(
                    new Intent(
                            this,
                            ProfilActivity.class
                    ).putExtra("individual", individual)
            );
        }
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(candidate != null) {
            warningTheUser();
        }
        if(filter != null)
            filter();
        if(startLocation != null && endLocation != null && mode != null)
            findRoute(startLocation,endLocation,mode);
        if(earthquake != null) {
            showPoint(earthquake.getLatLng());
        }
        if(currentLocation != null && earthquake != null){
            findRouteForMusterPoint();
        }
    }


    public void findRouteForMusterPoint(){
        String city = earthquake.getLocation().split("\\(" )[1].split("\\)")[0];
        buildRetrofit(Urls.APP_API_URL)
                .create(MusterPointService.class)
                .getByCity(city)
                .enqueue(new Callback<Parent<List<MusterPoint>>>() {
                    @Override
                    public void onResponse(Call<Parent<List<MusterPoint>>> call, Response<Parent<List<MusterPoint>>> response) {
                        if(response != null && response.body() != null && response.body().getData() != null) {
                            List<MusterPoint> data = response.body().getData();
                            LatLng destination = Compute.getTheNearestLocation(
                                    MusterPoint.getLatLngListFromMusterPointList(data),
                                    currentLocation.getLatLng()
                            );
                            findRoute(
                                    currentLocation,
                                    Location.getLocationFromLatLng(destination),
                                    "driving"
                            );
                        }
                    }

                    @Override
                    public void onFailure(Call<Parent<List<MusterPoint>>> call, Throwable t) {

                    }
                });
    }
    public void startSearchActivity(View view){
        Intent intent = new Intent(this, SearhActivity.class).putExtra("individual",individual);
        startActivity(intent);
    }

    public void startEarthquakeFilterActivity(View view){
        Intent intent = new Intent(this, EarthquakeFilterActivity.class);
        startActivity(intent);
    }
    public void startGetDirectionsActivity(View view){
        Intent intent = new Intent(this, GetDirectionsActivity.class);
        startActivity(intent);
    }
    public void filter(){
        buildRetrofit(Urls.AFAD_EARTHQUAKE_API_URL)
                .create(EarthquakeService.class)
                .get(filter.getOptions())
                .enqueue(new Callback<List<Earthquake>>() {
                    @Override
                    public void onResponse(Call<List<Earthquake>> call, Response<List<Earthquake>> response) {
                        mMap.clear();

                        List<Earthquake> list = response.body();
                        if(list != null && list.size() != 0) {
                            LatLng[] locations = new LatLng[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                locations[i] = new LatLng(list.get(i).getLatitude(), list.get(i).getLongitude());
                            }
                            showPointsOnTheMap(locations);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Earthquake>> call, Throwable t) {

                    }
                });
    }
    public void findRoute(Location start,Location end,String mode){
        DirectionsService service = retrofitDirections.create(DirectionsService.class);
        HashMap<String,String> options = new HashMap();

        options.put("origin",start.getLatitude() + "," + start.getLongitude());
        options.put("destination",end.getLatitude() + "," + end.getLongitude());
        options.put("mode",mode);
        options.put("key",key);

        Call<DirectionsModel> result = service.get(options);

        result.enqueue(new Callback<DirectionsModel>() {
            @Override
            public void onResponse(Call<DirectionsModel> call, Response<DirectionsModel> response) {
                if(response.isSuccessful()){
                    Route[] routes = response.body().getRoutes();

                    for(int i = 0; i < routes.length;i++){
                        List<LatLng> points = PolyUtil.decode(routes[i].getOverview_polyline().getPoints());
                        mMap.addMarker(
                                new MarkerOptions().position(points.get(0))
                        );
                        mMap.addMarker(
                                new MarkerOptions().position(points.get(points.size() - 1))
                        );

                        mMap.addPolyline(
                                new PolylineOptions().add(
                                        points.toArray(new LatLng[points.size()])
                                )
                        );
                    }
                    if(routes.length >= 0) {

                        Viewport viewports = routes[0].getBounds();

                        mMap.moveCamera(
                                CameraUpdateFactory.newLatLngBounds(
                                        new LatLngBounds(
                                                viewports.getSouthwest().getLatLng(),
                                                viewports.getNortheast().getLatLng()
                                        )
                                        , 150
                                )
                        );
                    }
                }
            }

            @Override
            public void onFailure(Call<DirectionsModel> call, Throwable t) {

            }
        });

    }

    public void warningTheUser(){

        showPoint(candidate.getGeometry().getLocation().getLatLng());
        String placeId = candidate.getPlaceId();
        buildRetrofit(Urls.APP_API_URL)
                .create(AddressService.class)
                .getWithBusinessWithProductsByPlaceId(placeId)
                .enqueue(new Callback<Parent<Address>>() {
                    @Override
                    public void onResponse(Call<Parent<Address>> call, Response<Parent<Address>> response) {
                        if(response != null && response.body() != null && response.body().getData() != null){
                            boolean devam = true;
                            List<Product> products = response.body().getData().getBusiness().getProducts();
                            for(int i = 0; i < individual.getDiseases().size() && devam;i++) {
                                Disease disease = individual.getDiseases().get(i);
                                for (int j = 0; j < disease.getProducts().size() && devam; j++) {
                                    List<Product> theProductsOfTheDisease = disease.getProducts();
                                    for (int k = 0; k < products.size() && devam; k++) {
                                        if (products.get(k).getId() == theProductsOfTheDisease.get(j).getId()) {
                                            devam = false;
                                            Toast.makeText(
                                                    MapsActivity.this,
                                                    "Dikkat!!!Bu konumda sizi hasta edebilecek ürünler var.",
                                                    Toast.LENGTH_LONG
                                            ).show();
                                        }
                                    }
                                }
                            }


                        }
                    }

                    @Override
                    public void onFailure(Call<Parent<Address>> call, Throwable t) {

                    }
                });

    }







}