package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class earthquakeadpter  extends ArrayAdapter<Earthquakeitem>{
    String primaryLocation;
    String locationOffset;
    private static final String LOCATION_SEPARATOR = " of ";
    public earthquakeadpter(EarthquakeActivity context, ArrayList<Earthquakeitem> items) {
     super(context,0,items);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemview=convertView;

        if (listitemview ==null){
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            }
            Earthquakeitem currentitem=getItem(position);

        TextView magtext=(TextView)listitemview.findViewById(R.id.magnitude);
         String mag=   formatMagnitude(currentitem.getMag());

         GradientDrawable magnitudeCircle = (GradientDrawable) magtext.getBackground();
        int magnitudeColor = getMagnitudeColor(currentitem.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        magtext.setText(mag);

        String originalLocation=currentitem.getName();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView primaryLocationView = (TextView) listitemview.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listitemview.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        Date dateobject =new Date(currentitem.getDate());
        String formateDate = formatDate(dateobject);
        TextView datetext=(TextView)listitemview.findViewById(R.id.date);
        datetext.setText(formateDate);
        String formateDate1 = formatTime(dateobject);
        TextView hourtext=(TextView)listitemview.findViewById(R.id.time);
        hourtext.setText(formateDate1);




        return listitemview;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
