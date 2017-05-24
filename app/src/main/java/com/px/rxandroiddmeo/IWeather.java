package com.px.rxandroiddmeo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/5/24.
 */

public interface IWeather
{
    @GET("101010100.html")
    Call<WeatherInfo> getWeather();
    @GET("101010101.html")
    Call<WeatherInfo> getWeather2();
}
