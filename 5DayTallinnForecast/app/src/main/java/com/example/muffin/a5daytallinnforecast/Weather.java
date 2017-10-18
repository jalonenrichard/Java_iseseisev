package com.example.muffin.a5daytallinnforecast;

import android.widget.ImageView;

/**
 * Created by Muffin on 29.09.2017.
 */


public class Weather {
    private String _weatherCondition, _weatherIconCode;
    private long _dateTime;
    private double _temperature, _windSpeed;

    /*@dateTime is the forecast time in UNIX code, @temperature is the forecast predicted temperature in celsius
      @weatherCondition is a word describing the weather (i.e. "RAIN"), @windSpeed is the predicted wind speed meters/sec
      @weatherIconCode is the weather icon code*/
    public Weather(long dateTime, double temperature, String weatherCondition, double windSpeed, String weatherIconCode) {
        _dateTime = dateTime;
        _temperature = temperature;
        _weatherCondition = weatherCondition;
        _windSpeed = windSpeed;
        _weatherIconCode = weatherIconCode;
    }

    public long getDateTime() {
        return _dateTime;
    }

    public double getTemperature() {
        return _temperature;
    }

    public String getWeatherCondition() {
        return _weatherCondition;
    }

    public double getWindSpeed() {
        return _windSpeed;
    }

    public String getWeatherIconCode() {
        return _weatherIconCode;
    }

}
