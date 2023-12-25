//[app](../../../index.md)/[com.example.myweatherapplication.network](../index.md)/[WeatherApiService](index.md)

# WeatherApiService

[androidJvm]\
interface [WeatherApiService](index.md)

Definieert de structuur van de weer-API.

## Functions

| Name | Summary |
|---|---|
| [getWeatherLocation](get-weather-location.md) | [androidJvm]<br>@GET(value = &quot;current.json?key=40d52432438b44ba8b5190616231511 &quot;)<br>abstract suspend fun [getWeatherLocation](get-weather-location.md)(@Query(value = &quot;q&quot;)realLocation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ApiWeatherLocationInfo](../-api-weather-location-info/index.md)<br>Haalt de huidige weerinformatie op voor de opgegeven locatie. |
| [getWeatherLocationAsFlow](../get-weather-location-as-flow.md) | [androidJvm]<br>fun [WeatherApiService](index.md).[getWeatherLocationAsFlow](../get-weather-location-as-flow.md)(loc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[ApiWeatherLocationInfo](../-api-weather-location-info/index.md)&gt;<br>Extension-functie om [WeatherApiService.getWeatherLocation](get-weather-location.md) als een Flow uit te zenden. |
