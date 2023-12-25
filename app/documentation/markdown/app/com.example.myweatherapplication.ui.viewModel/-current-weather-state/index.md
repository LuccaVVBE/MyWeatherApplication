//[app](../../../index.md)/[com.example.myweatherapplication.ui.viewModel](../index.md)/[CurrentWeatherState](index.md)

# CurrentWeatherState

[androidJvm]\
data class [CurrentWeatherState](index.md)(val locatieInfo: [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md) = LocatieInfo(
        placeName = &quot;Fetching...&quot;,
        temp =15.0,
        feelsLike = 10.0,
        icon =&quot;&quot;,
        windSpeed =14.0,
        windDirection =210,
        pressure =1013.0,
        humidity =60,
        visibility =15.0,
        uv =2.0), val newLocationName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)

Representeert de staat van de huidige weersinformatie in de weer-applicatie.

## Constructors

| | |
|---|---|
| [CurrentWeatherState](-current-weather-state.md) | [androidJvm]<br>constructor(locatieInfo: [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md) = LocatieInfo(         placeName = &quot;Fetching...&quot;,         temp =15.0,         feelsLike = 10.0,         icon =&quot;&quot;,         windSpeed =14.0,         windDirection =210,         pressure =1013.0,         humidity =60,         visibility =15.0,         uv =2.0), newLocationName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |

## Properties

| Name | Summary |
|---|---|
| [locatieInfo](locatie-info.md) | [androidJvm]<br>val [locatieInfo](locatie-info.md): [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md)<br>De huidige weersinformatie voor een specifieke locatie. |
| [newLocationName](new-location-name.md) | [androidJvm]<br>val [newLocationName](new-location-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>De naam van een nieuwe locatie die wordt toegevoegd. |
