package com.thenqlv.bitirmeprojesiclient;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.format.DateFormat;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.google.gson.GsonBuilder;
import com.thenqlv.bitirmeprojesiclient.Entities.Afad.Earthquake;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Location;
import com.thenqlv.bitirmeprojesiclient.Services.Afad.EarthquakeService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class EarthquakeIntentService extends IntentService {

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.thenqlv.bitirmeprojesiclient.action.FOO";
    private static final String ACTION_BAZ = "com.thenqlv.bitirmeprojesiclient.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.thenqlv.bitirmeprojesiclient.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.thenqlv.bitirmeprojesiclient.extra.PARAM2";

    public EarthquakeIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, EarthquakeIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, EarthquakeIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
        checkLastEartquakes();

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
    private String CHANNEL_ID = "Earthquke";
    private NotificationManager manager;
    private NotificationChannel channel;



    private void createChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_HIGH);
            manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
    private void createNotification(int id,Earthquake earthquake){

        Intent i = new Intent(this, MapsActivity.class)
                .putExtra("earthquake",earthquake)
                .putExtra("currentLocation",new Location(lat,lon));
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                id,
                i,
                0
        );
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.danger)
                .setContentTitle(
                        earthquake.getEventID() + " -> " +
                                earthquake.getLatitude() + " : " +
                                earthquake.getLongitude()
                )
                .setContentText("Dikkat Deprem!!!")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build();

        manager.notify(id, notification);
    }


    private DateFormat dateFormat;

    private String key = "AIzaSyAkDEFUmJmVRAl8GhpcIYZs5jl03VzaeCQ";
    private Retrofit retrofitAfad;
    private int timeOfset = 3;
    private int interval = 6;
    private long ms = 3600000;

    private double lat = 38.241;
    private double lon = 38.133;
    private double maxRad = 100000;
    private double minRad = 0;
    private int lastEventId = 0;
    private int notificationId = 0;

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
    public void createNotifications(){
        EarthquakeService service = retrofitAfad.create(EarthquakeService.class);
        HashMap<String,String> options = new HashMap<>();
        long startTime = Calendar.getInstance().getTime().getTime() - (timeOfset + interval) * ms;
        long endTime = Calendar.getInstance().getTime().getTime() - (timeOfset - interval) * ms;

        options.put(
                "start",
                dateFormat.format(
                        "yyyy-MM-dd HH:mm:ss",
                        new Date(startTime)
                ).toString()
        );
        options.put(
                "end",
                dateFormat.format(
                        "yyyy-MM-dd HH:mm:ss",
                        new Date(endTime)
                ).toString()
        );
        options.put("lat",String.valueOf(lat));
        options.put("lon",String.valueOf(lon));
        options.put("maxrad",String.valueOf(maxRad));
        options.put("minrad",String.valueOf(minRad));
        Call<List<Earthquake>> result = service.get(options);

        result.enqueue(new Callback<List<Earthquake>>() {
            @Override
            public void onResponse(Call<List<Earthquake>> call, Response<List<Earthquake>> response) {
                if(response.isSuccessful()){
                    List<Earthquake> list = response.body();

                    if(list.size() > 0) {
                        Earthquake earthquake = list.get(list.size() - 1);
                        if(earthquake.getEventID() != lastEventId) {
                            createNotification(notificationId,earthquake);
                            notificationId++;
                            lastEventId = list.get(list.size() - 1).getEventID();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Earthquake>> call, Throwable t) {

            }
        });

    }

    public void checkLastEartquakes(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    createNotifications();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }






    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        createChannel();
        dateFormat = new DateFormat();
        retrofitAfad = buildRetrofit(Urls.AFAD_EARTHQUAKE_API_URL);
    }






}