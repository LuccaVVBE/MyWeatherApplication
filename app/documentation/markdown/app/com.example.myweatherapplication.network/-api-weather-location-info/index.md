//[app](../../../index.md)/[com.example.myweatherapplication.network](../index.md)/[ApiWeatherLocationInfo](index.md)

# ApiWeatherLocationInfo

[androidJvm]\
@Serializable

data class [ApiWeatherLocationInfo](index.md)(val location: [ApiWeatherLocation](../-api-weather-location/index.md), val current: [ApiWeatherCurrent](../-api-weather-current/index.md))

Dataklasse voor het representen van weerlocatie-informatie van de externe API.

## Constructors

| | |
|---|---|
| [ApiWeatherLocationInfo](-api-weather-location-info.md) | [androidJvm]<br>constructor(location: [ApiWeatherLocation](../-api-weather-location/index.md), current: [ApiWeatherCurrent](../-api-weather-current/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [current](current.md) | [androidJvm]<br>val [current](current.md): [ApiWeatherCurrent](../-api-weather-current/index.md)<br>De [ApiWeatherCurrent](../-api-weather-current/index.md) die de huidige weerinformatie bevat. |
| [location](location.md) | [androidJvm]<br>val [location](location.md): [ApiWeatherLocation](../-api-weather-location/index.md)<br>De [ApiWeatherLocation](../-api-weather-location/index.md) die de locatiegegevens bevat. |
