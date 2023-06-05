package com.thenqlv.bitirmeprojesiclient.Filters;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EarthquakeFilter implements Serializable {
    private String startDate; private String endDate;
    private String minMagnitude; private String maxMagnitude;
    private String minDepth; private String maxDepth;
    private String minLat; private String maxLat;
    private String minLon; private String maxLon;
    private String lat; private String lon;
    private String minRad; private String maxRad;
    private String limit;

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setMinMagnitude(String minMagnitude) {
        this.minMagnitude = minMagnitude;
    }

    public void setMaxMagnitude(String maxMagnitude) {
        this.maxMagnitude = maxMagnitude;
    }

    public void setMinDepth(String minDepth) {
        this.minDepth = minDepth;
    }

    public void setMaxDepth(String maxDepth) {
        this.maxDepth = maxDepth;
    }

    public void setMinLat(String minLat) {
        this.minLat = minLat;
    }

    public void setMaxLat(String maxLat) {
        this.maxLat = maxLat;
    }

    public void setMinLon(String minLon) {
        this.minLon = minLon;
    }

    public void setMaxLon(String maxLon) {
        this.maxLon = maxLon;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setMinRad(String minRad) {
        this.minRad = minRad;
    }

    public void setMaxRad(String maxRad) {
        this.maxRad = maxRad;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getMinMagnitude() {
        return minMagnitude;
    }

    public String getMaxMagnitude() {
        return maxMagnitude;
    }

    public String getMinDepth() {
        return minDepth;
    }

    public String getMaxDepth() {
        return maxDepth;
    }

    public String getMinLat() {
        return minLat;
    }

    public String getMaxLat() {
        return maxLat;
    }

    public String getMinLon() {
        return minLon;
    }

    public String getMaxLon() {
        return maxLon;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getMinRad() {
        return minRad;
    }

    public String getMaxRad() {
        return maxRad;
    }

    public String getLimit() {
        return limit;
    }
    public Map<String,String> getOptions(){
        Map<String,String> r = new HashMap<>();
        if(startDate.length() != 0)
            r.put("start",startDate);
        if(endDate.length() != 0)
            r.put("end",endDate);
        if(minMagnitude.length() != 0)
            r.put("minmag",minMagnitude);
        if(maxMagnitude.length() != 0)
            r.put("maxmag",maxMagnitude);
        if(minDepth .length() != 0)
            r.put("mindepth",minDepth);
        if(maxDepth.length() != 0)
            r.put("maxdepth",maxDepth);
        if(lat.length() != 0)
            r.put("lat",lon);
        if(lon.length() != 0)
            r.put("lon",lat);
        if(minRad.length() != 0)
            r.put("minrad",minRad);
        if(maxRad.length() != 0)
            r.put("maxrad",maxRad);
        if(minLat.length() != 0)
            r.put("minlat",minLat);
        if(maxLat.length() != 0)
            r.put("maxlat",maxLat);
        if(minLon.length() != 0)
            r.put("minlon",minLon);
        if(maxLon.length() != 0)
            r.put("maxlon",maxLon);
        if(limit.length() != 0)
            r.put("limit",limit);
        return r;
    }
}
