package com.siddharth.weather.Util;

public class constants {

    public static final int REQUEST_CODE = 123; // Request Code for permission request callback
    public static final int CITY_CODE = 456; // Request code for starting new activity for result callback

    // Base URL for the OpenWeatherMap API. More secure https is a premium feature =(
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";

    // App ID to use OpenWeather data
    public static final String APP_ID = "2e1437f5a3c9f5e5bb98cc033c17eae3";

    // Time between location updates (5000 milliseconds or 5 seconds)
    public static final long MIN_TIME = 5000;

    // Distance between location updates (1000m or 1km)
    public static final float MIN_DISTANCE = 1000;

}
