//[app](../../../index.md)/[com.example.myweatherapplication.data](../index.md)/[WeatherRepository](index.md)

# WeatherRepository

interface [WeatherRepository](index.md)

Repository-interface voor het ophalen en beheren van weergerelateerde locatie-informatie.

#### Inheritors

| |
|---|
| [CachingWeatherRepository](../-caching-weather-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [deleteWeatherLocation](delete-weather-location.md) | [androidJvm]<br>abstract suspend fun [deleteWeatherLocation](delete-weather-location.md)(locatieInfo: [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md))<br>Verwijdert de opgegeven weerlocatie uit de database. |
| [getWeatherLocation](get-weather-location.md) | [androidJvm]<br>abstract fun [getWeatherLocation](get-weather-location.md)(realLocation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md)&gt;<br>Haalt de weerinformatie voor de opgegeven locatie op als een Flow van [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md). |
| [getWeatherLocations](get-weather-locations.md) | [androidJvm]<br>abstract fun [getWeatherLocations](get-weather-locations.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md)&gt;&gt;<br>Haalt alle weerlocaties op als een Flow van een lijst van [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md). |
| [insertWeatherLocation](insert-weather-location.md) | [androidJvm]<br>abstract suspend fun [insertWeatherLocation](insert-weather-location.md)(locatieInfo: [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md))<br>Voegt de opgegeven weerlocatie toe aan de database. |
| [refresh](refresh.md) | [androidJvm]<br>abstract suspend fun [refresh](refresh.md)(loc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Vernieuwt de weerinformatie voor de opgegeven locatie en retourneert de bijgewerkte locatienaam. |
| [updateWeatherLocation](update-weather-location.md) | [androidJvm]<br>abstract suspend fun [updateWeatherLocation](update-weather-location.md)(locatieInfo: [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md))<br>Werkt de opgegeven weerlocatie in de database bij. |
