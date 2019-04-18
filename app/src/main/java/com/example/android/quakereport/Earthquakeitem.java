package com.example.android.quakereport;

import java.util.Date;

public class Earthquakeitem {
    private Double mag;
    private String name;
    private long date;
    private String mUrl;


    public Earthquakeitem(Double mag, String name, long date,String url) {
        this.mag = mag;
        this.name = name;
        this.date = date;
        mUrl=url;
    }

    public Double getMag() {
        return mag;
    }

    public String getName() {
        return name;
    }

    public long getDate() {

        return date;
    }
    public String getUrl() {
        return mUrl;
    }


}
