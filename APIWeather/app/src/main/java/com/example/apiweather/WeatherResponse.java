package com.example.apiweather;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("main")
    private Main main;

    public Main getMain() {
        return main;
    }

    public class Main {
        @SerializedName("temp")
        private double temp;

        public double getTemp() {
            return temp;
        }
    }
}
