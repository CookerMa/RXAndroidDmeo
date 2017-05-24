package com.px.rxandroiddmeo;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;


public interface RxWeather
{
    @GET("101010100.html")
    Observable<WeatherInfo> getWeather();
}
