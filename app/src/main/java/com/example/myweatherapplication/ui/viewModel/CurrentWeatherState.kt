package com.example.myweatherapplication.ui.viewModel

import com.example.myweatherapplication.ui.model.LocatieInfo

data class CurrentWeatherState(
    val locatieInfo: LocatieInfo = LocatieInfo(
        placeName = "Fetching...",
        temp =15.0,
        feelsLike = 10.0,
        icon ="",
        windSpeed =14.0,
        windDirection =210,
        pressure =1013.0,
        humidity =60,
        visibility =15.0,
        uv =2.0),
)

data class WeatherLocationListState(
    val weatherLocationList: List<LocatieInfo> = listOf(
        LocatieInfo(placeName = "Loc1...",
            temp =15.0,
            feelsLike = 10.0,
            icon ="",
            windSpeed =14.0,
            windDirection =210,
            pressure =1013.0,
            humidity =60,
            visibility =15.0,
            uv =2.0),
        LocatieInfo(placeName = "Loc2...",
            temp =15.0,
            feelsLike = 10.0,
            icon ="",
            windSpeed =14.0,
            windDirection =210,
            pressure =1013.0,
            humidity =60,
            visibility =15.0,
            uv =2.0)
    )
)

//the sealed interface has only three possible values
sealed interface WeatherApiState{
    object Success : WeatherApiState
    object Error: WeatherApiState
    object Loading : WeatherApiState
}
