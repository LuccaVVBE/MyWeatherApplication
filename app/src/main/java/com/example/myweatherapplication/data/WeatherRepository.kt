package com.example.myweatherapplication.data

import com.example.myweatherapplication.network.WeatherApiService
import com.example.myweatherapplication.network.asDomainObject
import com.example.myweatherapplication.ui.model.LocatieInfo

interface WeatherRepository {
    suspend fun getWeatherLocation(realLocation: String): LocatieInfo
}

class ApiWeatherRepository(
    private val weatherApiService: WeatherApiService
): WeatherRepository{
    override suspend fun getWeatherLocation(realLocation: String): LocatieInfo {
        return weatherApiService.getWeatherLocation(realLocation).asDomainObject();
    }
}