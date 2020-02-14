package com.siddharth.weather.Model;


import org.json.JSONException;
import org.json.JSONObject;

public class WeatherModel {

    // Member variables that hold our  weather information.
    private String mTemperature;
    private String mCity;
    private String mIconName;
    private int mCondition;


    // Create a WeatherDataModel from a JSON.
    //  call this for standard constructor.
    public static WeatherModel fromJson(JSONObject jsonObject) {


        try {
            WeatherModel weatherData = new WeatherModel();

            weatherData.mCity = jsonObject.getString("name");
            weatherData.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherData.mIconName = updateWeatherIcon(weatherData.mCondition);

            double tempResult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            int roundedValue = (int) Math.rint(tempResult);

            weatherData.mTemperature = Integer.toString(roundedValue);

            return weatherData;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    //  check condition and set image using drawable...
    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "strom";
        } else if (condition >= 300 && condition < 500) {
            return "rain";
        } else if (condition >= 500 && condition < 600) {
            return "dizling";
        } else if (condition >= 600 && condition <= 700) {
            return "snow";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "strom";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloud";
        } else if (condition >= 900 && condition <= 902) {
            return "strom";
        } else if (condition == 903) {
            return "snow";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "strom";
        }

        return "finding";
    }

    // Getter methods for temperature, city, and icon name:

    public String getTemperature() {
        return mTemperature + "°";
    }

    public String getCity() {
        return mCity;
    }

    public String getIconName() {
        return mIconName;
    }
}
