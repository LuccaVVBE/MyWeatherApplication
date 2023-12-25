package com.example.myweatherapplication.data

import android.content.Context
import com.example.myweatherapplication.data.database.LocatieInfoDb
import com.example.myweatherapplication.network.WeatherApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Interface voor het beheren van afhankelijkheden in de applicatie.
 */
interface AppContainer {
    val weatherRepository: WeatherRepository
}

/**
 * Standaard implementatie van [AppContainer] die verantwoordelijk is voor het beheren van afhankelijkheden.
 *
 * @property context De [Context] van de applicatie.
 */
class DefaultAppContainer(private val context : Context): AppContainer{

    private val baseUrl = "https://api.weatherapi.com/v1/"
    // om alleen de juiste waarden uit mijn http GET-verzoek te halen
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

    /**
     * De [WeatherRepository] die wordt gebruikt in de applicatie.
     */
    override val weatherRepository: WeatherRepository by lazy {
    CachingWeatherRepository(LocatieInfoDb.getDatabase(context = context).locatieInfoDao(), retrofitService)
    }

}