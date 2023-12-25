package com.example.myweatherapplication.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Definieert de structuur van de weer-API.
 */
interface WeatherApiService {

    /**
     * Haalt de huidige weerinformatie op voor de opgegeven locatie.
     *
     * @param realLocation De naam van de locatie waarvoor de weerinformatie moet worden opgehaald.
     * @return Een [ApiWeatherLocationInfo] met de weerinformatie.
     */
    @GET("current.json?key=40d52432438b44ba8b5190616231511 ")
    suspend fun getWeatherLocation(@Query("q")realLocation: String): ApiWeatherLocationInfo
}

/**
 * Extension-functie om [WeatherApiService.getWeatherLocation] als een [Flow] uit te zenden.
 *
 * @param loc De naam van de locatie waarvoor de weerinformatie moet worden opgehaald.
 * @return Een [Flow] van [ApiWeatherLocationInfo] met de weerinformatie.
 */
fun WeatherApiService.getWeatherLocationAsFlow(loc:String) : Flow<ApiWeatherLocationInfo> = flow{
    emit(getWeatherLocation(loc))
}