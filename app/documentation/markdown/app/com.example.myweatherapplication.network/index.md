//[app](../../index.md)/[com.example.myweatherapplication.network](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ApiWeatherCurrent](-api-weather-current/index.md) | [androidJvm]<br>@Serializable<br>data class [ApiWeatherCurrent](-api-weather-current/index.md)(val temp_c: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val feelslike_c: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val condition: [ApiWeatherCurrentCondition](-api-weather-current-condition/index.md), val wind_kph: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val wind_degree: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val pressure_mb: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val cloud: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val vis_km: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val uv: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))<br>Dataklasse voor het representen van huidige weerinformatie van de externe API. |
| [ApiWeatherCurrentCondition](-api-weather-current-condition/index.md) | [androidJvm]<br>@Serializable<br>data class [ApiWeatherCurrentCondition](-api-weather-current-condition/index.md)(val icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Dataklasse voor het representen van huidige weersomstandigheden van de externe API. |
| [ApiWeatherLocation](-api-weather-location/index.md) | [androidJvm]<br>@Serializable<br>data class [ApiWeatherLocation](-api-weather-location/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Dataklasse voor het representen van locatiegegevens van de externe API. |
| [ApiWeatherLocationInfo](-api-weather-location-info/index.md) | [androidJvm]<br>@Serializable<br>data class [ApiWeatherLocationInfo](-api-weather-location-info/index.md)(val location: [ApiWeatherLocation](-api-weather-location/index.md), val current: [ApiWeatherCurrent](-api-weather-current/index.md))<br>Dataklasse voor het representen van weerlocatie-informatie van de externe API. |
| [WeatherApiService](-weather-api-service/index.md) | [androidJvm]<br>interface [WeatherApiService](-weather-api-service/index.md)<br>Definieert de structuur van de weer-API. |

## Functions

| Name | Summary |
|---|---|
| [asDomainObject](as-domain-object.md) | [androidJvm]<br>fun Flow&lt;[ApiWeatherLocationInfo](-api-weather-location-info/index.md)&gt;.[asDomainObject](as-domain-object.md)(): Flow&lt;[LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md)&gt;<br>Extensiefunctie voor een Flow van [ApiWeatherLocationInfo](-api-weather-location-info/index.md) om deze om te zetten naar een Flow van [LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md). |
| [getWeatherLocationAsFlow](get-weather-location-as-flow.md) | [androidJvm]<br>fun [WeatherApiService](-weather-api-service/index.md).[getWeatherLocationAsFlow](get-weather-location-as-flow.md)(loc: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[ApiWeatherLocationInfo](-api-weather-location-info/index.md)&gt;<br>Extension-functie om [WeatherApiService.getWeatherLocation](-weather-api-service/get-weather-location.md) als een Flow uit te zenden. |
