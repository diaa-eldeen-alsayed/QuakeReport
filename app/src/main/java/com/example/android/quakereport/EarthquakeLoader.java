package com.example.android.quakereport;

import android.content.Context;


import com.example.android.quakereport.Earthquakeitem;
import com.example.android.quakereport.QueryUtils;
import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquakeitem>> {
   private String mUrl;
    public EarthquakeLoader(Context context ,String url) {
        super(context);
        mUrl=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquakeitem> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Earthquakeitem> earthquakeitems= QueryUtils.fetchEarthquakeData(mUrl);
        return  earthquakeitems;
    }


}
