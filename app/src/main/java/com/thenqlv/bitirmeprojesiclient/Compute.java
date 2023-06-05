package com.thenqlv.bitirmeprojesiclient;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class Compute {
    public static LatLngBounds findTheBounds(LatLng[] points){

        double lat0 = points[0].latitude,lng0 = points[0].longitude;
        double lat1 = points[0].latitude,lng1 = points[0].longitude;

        for(int i = 1;i < points.length;i++) {
            if (points[i].latitude < lat0)
                lat0 = points[i].latitude;
            if (points[i].longitude < lng0)
                lng0 = points[i].longitude;
            if (points[i].latitude > lat1)
                lat1 = points[i].latitude;
            if (points[i].longitude > lng1)
                lng1 = points[i].longitude;
        }

        return new LatLngBounds(
                new LatLng(lat0,lng0),
                new LatLng(lat1,lng1)
        );
    }

    private static double deg2rad(double deg) {
        return deg * (Math.PI/180);
    }

    public static double getDistanceFromLatLonInKm(LatLng x,LatLng y) {
        double lat1 = x.latitude,lon1 = x.longitude,lat2 = y.latitude,lon2 = y.longitude;

        double R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2-lat1);  // deg2rad below
        double dLon = deg2rad(lon2-lon1);
        double a =
                Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2)
                ;
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c; // Distance in km
        return d;
    }

    private static double oklid(LatLng a,LatLng b){
        return Math.sqrt(Math.pow(a.latitude - b.latitude,2) + Math.pow(a.longitude - b.longitude,2));
    }

    public static LatLng getTheNearestLocation(LatLng[] points,LatLng k){
        LatLng min = points[0];
        double value = oklid(points[0],k),temp = 0;
        for(int i = 1; i < points.length;i++){
            temp = oklid(points[i],k);
            if(temp < value) {
                value = temp;
                min = points[i];
            }
        }
        return min;
    }

}
