package com.example.muffin.a5daytallinnforecast;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.Date;

/**
 * Created by Muffin on 29.09.2017.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {

    public WeatherAdapter(Activity context, ArrayList<Weather> weathers) {
        super(context, 0, weathers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Weather weather = getItem(position);


        TextView timeClock = (TextView) listItemView.findViewById(R.id.time_clock);
        Date date = new Date(weather.getDateTime() * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd HH:mm");
        sdf.setTimeZone(TimeZone.getDefault());
        String formattedDate = sdf.format(date);
        timeClock.setText(formattedDate);

        TextView windSpeed = (TextView) listItemView.findViewById(R.id.wind_speed);
        String windSpeedText = weather.getWindSpeed() + " m/s";
        windSpeed.setText(windSpeedText);

        TextView temperature = (TextView) listItemView.findViewById(R.id.temperature);
        String temperatureText = weather.getTemperature() + "\u00b0";
        temperature.setText(temperatureText);

        ImageView weatherImage = (ImageView) listItemView.findViewById(R.id.weather_image);
        weatherImage.setImageResource(chooseWeatherImage(weather.getWeatherIconCode()));

        return listItemView;
    }

    private int chooseWeatherImage(String weatherIconCode) {
        int code = 0;
        switch (weatherIconCode) {
            case "01d":
                code = R.drawable.d01;
                break;
            case "01n":
                code = R.drawable.n01;
                break;
            case "02d":
                code = R.drawable.d02;
                break;
            case "02n":
                code = R.drawable.n02;
                break;
            case "03d":
                code = R.drawable.d03;
                break;
            case "03n":
                code = R.drawable.n03;
                break;
            case "04d":
                code = R.drawable.d04;
                break;
            case "04n":
                code = R.drawable.n04;
                break;
            case "09d":
                code = R.drawable.d09;
                break;
            case "09n":
                code = R.drawable.n09;
                break;
            case "10d":
                code = R.drawable.d10;
                break;
            case "10n":
                code = R.drawable.n10;
                break;
            case "11d":
                code = R.drawable.d11;
                break;
            case "11n":
                code = R.drawable.n11;
                break;
            case "13d":
                code = R.drawable.d13;
                break;
            case "13n":
                code = R.drawable.n13;
                break;
            case "50d":
                code = R.drawable.d50;
                break;
            case "50n":
                code = R.drawable.n50;
                break;
        }
        return code;
    }


}
