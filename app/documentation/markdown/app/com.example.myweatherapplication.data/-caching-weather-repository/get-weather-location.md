//[app](../../../index.md)/[com.example.myweatherapplication.data](../index.md)/[CachingWeatherRepository](index.md)/[getWeatherLocation](get-weather-location.md)

# getWeatherLocation

[androidJvm]\
open override fun [getWeatherLocation](get-weather-location.md)(realLocation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Flow&lt;[LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md)&gt;

Haalt de weerinformatie voor de opgegeven locatie op als een Flow van [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md).

#### Return

Een Flow van [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md) die de weerinformatie vertegenwoordigt.

#### Parameters

androidJvm

| | |
|---|---|
| realLocation | De naam van de locatie waarvan de weerinformatie moet worden opgehaald. |
