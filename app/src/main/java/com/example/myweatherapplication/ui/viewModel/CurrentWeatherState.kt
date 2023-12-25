package com.example.myweatherapplication.ui.viewModel

import com.example.myweatherapplication.ui.model.LocatieInfo

/**
 * Representeert de staat van de huidige weersinformatie in de weer-applicatie.
 *
 * @property locatieInfo De huidige weersinformatie voor een specifieke locatie.
 * @property newLocationName De naam van een nieuwe locatie die wordt toegevoegd.
 */
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
    val newLocationName:String = ""
)

/**
 * Representeert de staat van de lijst met weerlocaties in de weer-applicatie.
 *
 * @property weatherLocationList Een lijst met weerinformatie voor verschillende locaties.
 */
data class WeatherLocationListState(
    val weatherLocationList: List<LocatieInfo> = listOf()
)

/**
 * Gesealde interface die de status van de weer-API-aanroepen vertegenwoordigt.
 */
sealed interface WeatherApiState{
    /**
     * Geeft aan dat de weer-API-aanroep succesvol is verlopen.
     */
    object Success : WeatherApiState

    /**
     * Geeft aan dat er een fout is opgetreden tijdens de weer-API-aanroep.
     */
    object Error: WeatherApiState

    /**
     * Geeft aan dat de weer-API-aanroep bezig is met laden.
     */
    object Loading : WeatherApiState
}
