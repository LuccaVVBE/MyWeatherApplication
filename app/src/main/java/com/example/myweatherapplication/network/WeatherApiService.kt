package com.example.myweatherapplication.network

import retrofit2.http.GET
import retrofit2.http.Query

//define what the API looks like
interface WeatherApiService {
    //suspend is added to force the user to call this in a coroutine scope
    @GET("current.json?key=40d52432438b44ba8b5190616231511 ")
    suspend fun getWeatherLocation(@Query("q")realLocation: String): ApiWeatherLocationInfo
}