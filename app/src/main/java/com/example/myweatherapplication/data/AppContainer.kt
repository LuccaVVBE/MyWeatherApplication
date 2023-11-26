package com.example.myweatherapplication.data

import android.content.Context
import com.example.myweatherapplication.data.database.LocatieInfoDb
import com.example.myweatherapplication.network.WeatherApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val weatherRepository: WeatherRepository
}

//container that takes care of dependencies
class DefaultAppContainer(private val context : Context): AppContainer{

    private val baseUrl = "https://api.weatherapi.com/v1/"
    //to only get the correct values out of my http GET request
    private val json = Json{
        ignoreUnknownKeys=true
    }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(baseUrl)
        .build()

    private val retrofitService : WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }

/*
    override val weatherRepository: WeatherRepository by lazy {
        ApiWeatherRepository(retrofitService)
    }
 */
    override val weatherRepository: WeatherRepository by lazy {
        OfflineWeatherRepository(LocatieInfoDb.getDatabase(context = context).locatieInfoDao())
    }

}