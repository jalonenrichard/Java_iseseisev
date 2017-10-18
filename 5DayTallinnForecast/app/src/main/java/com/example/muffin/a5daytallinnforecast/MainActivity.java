package com.example.muffin.a5daytallinnforecast;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //////////// 5-DAY WEATHER FORECAST TALLINN //////////////////
    private static String _urlString = "http://api.openweathermap.org/data/2.5/forecast?id=588409&units=metric&APPID=18f146deafcf7f69df8670807b59db62";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherAsyncTask weatherAsyncTask = new WeatherAsyncTask();
        weatherAsyncTask.execute(_urlString);
    }

    private void updateUi(ArrayList<Weather> weatherList) {
        WeatherAdapter weatherAdapter = new WeatherAdapter(this, weatherList);
        ListView listView = (ListView) findViewById(R.id.listview_weather);
        listView.setAdapter(weatherAdapter);
    }

    private class WeatherAsyncTask extends AsyncTask<String, Void, ArrayList<Weather>> {
        protected ArrayList<Weather> doInBackground(String... urls) {
            ArrayList<Weather> result = Utils.fetchWeatherData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Weather> result) {
            updateUi(result);
        }
    }

}
