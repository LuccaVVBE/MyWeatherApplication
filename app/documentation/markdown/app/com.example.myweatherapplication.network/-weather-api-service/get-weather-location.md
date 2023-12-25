//[app](../../../index.md)/[com.example.myweatherapplication.network](../index.md)/[WeatherApiService](index.md)/[getWeatherLocation](get-weather-location.md)

# getWeatherLocation

[androidJvm]\

@GET(value = &quot;current.json?key=40d52432438b44ba8b5190616231511 &quot;)

abstract suspend fun [getWeatherLocation](get-weather-location.md)(@Query(value = &quot;q&quot;)realLocation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ApiWeatherLocationInfo](../-api-weather-location-info/index.md)

Haalt de huidige weerinformatie op voor de opgegeven locatie.

#### Return

Een [ApiWeatherLocationInfo](../-api-weather-location-info/index.md) met de weerinformatie.

#### Parameters

androidJvm

| | |
|---|---|
| realLocation | De naam van de locatie waarvoor de weerinformatie moet worden opgehaald. |
