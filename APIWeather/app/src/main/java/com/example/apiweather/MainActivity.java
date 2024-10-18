package com.example.apiweather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{

    private static final String API_KEY = "";
    private EditText cityInput;
    private TextView weatherResult;
    private Button getWeatherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityInput = findViewById(R.id.cityInput);
        weatherResult = findViewById(R.id.weatherResult);
        getWeatherButton = findViewById(R.id.getWeatherButton);

        getWeatherButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fetchWeather();
            }
        });
    }

    private void fetchWeather()
    {
        String cityName = cityInput.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApiService weatherApiService = retrofit.create(WeatherApiService.class);
        Call<WeatherResponse> call = weatherApiService.getWeather(cityName, API_KEY, "metric");

        // Log the request URL
        Log.d("WeatherRequest", "URL: " + call.request().url());

        call.enqueue(new Callback<WeatherResponse>()
        {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response)
            {
                if (response.isSuccessful() && response.body() != null)
                {
                    double temperature = response.body().getMain().getTemp();
                    weatherResult.setText("Temperature in " + cityName + ": " + temperature + "°C");
                }
                else
                {
                    weatherResult.setText("Error: City not found! Code: " + response.code() + " Message: " + response.message());
                    Log.e("API Error", "Code: " + response.code() + " Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t)
            {
                weatherResult.setText("Error: Could not connect to the weather service.");
                Log.e("API Error", t.getMessage());
            }
        });
    }

}
