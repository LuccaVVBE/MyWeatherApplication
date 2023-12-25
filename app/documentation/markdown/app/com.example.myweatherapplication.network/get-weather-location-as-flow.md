//[app](../../index.md)/[com.example.myweatherapplication.network](index.md)/[getWeatherLocationAsFlow](get-weather-location-as-flow.md)

# getWeatherLocationAsFlow

[androidJvm]\
fun [WeatherApiService](-weather-api-service/index.md).[getWeatherLocationAsFlow](get-weather-location-as-flow.md)(loc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[ApiWeatherLocationInfo](-api-weather-location-info/index.md)&gt;

Extension-functie om [WeatherApiService.getWeatherLocation](-weather-api-service/get-weather-location.md) als een Flow uit te zenden.

#### Return

Een Flow van [ApiWeatherLocationInfo](-api-weather-location-info/index.md) met de weerinformatie.

#### Parameters

androidJvm

| | |
|---|---|
| loc | De naam van de locatie waarvoor de weerinformatie moet worden opgehaald. |
