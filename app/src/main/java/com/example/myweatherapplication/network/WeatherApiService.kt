package com.example.myweatherapplication.network

import retrofit2.http.GET
import retrofit2.http.Query

//define what the API looks like
interface WeatherApiService {
    //suspend is added to force the user to call this in a coroutine scope
    @GET("?q=")
    suspend fun getWeatherLocation(@Query("q")realLocation: String): ApiWeatherLocationInfo
}
