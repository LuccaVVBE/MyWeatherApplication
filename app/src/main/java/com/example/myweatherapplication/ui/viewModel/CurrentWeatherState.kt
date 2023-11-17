package com.example.myweatherapplication.ui.viewModel

import com.example.myweatherapplication.ui.model.LocatieInfo

data class CurrentWeatherState(
    val locatieInfo:LocatieInfo = LocatieInfo(
        placeName = "Fetching...",
        temp =15,
        icon ="",
        windSpeed =14,
        windDirection =210,
        pressure =1013,
        humidity =60,
        visibility =15,
        uv =2),
)

//the sealed interface has only three possible values
sealed interface WeatherApiState{
    data class Success(val weatherLocatieInfo: LocatieInfo) : WeatherApiState
    object Error: WeatherApiState
    object Loading : WeatherApiState
}
