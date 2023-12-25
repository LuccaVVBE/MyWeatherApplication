//[app](../../../index.md)/[com.example.myweatherapplication.ui.model](../index.md)/[LocatieInfo](index.md)

# LocatieInfo

data class [LocatieInfo](index.md)(var placeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var temp: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), var feelsLike: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), var icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var windSpeed: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), var windDirection: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), var pressure: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), var humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), var visibility: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), var uv: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))

Dataklasse die de weergerelateerde informatie voor een locatie vertegenwoordigt.

#### Parameters

androidJvm

| | |
|---|---|
| placeName | De naam van de locatie. |
| temp | De temperatuur op de locatie. |
| feelsLike | De gevoelstemperatuur op de locatie. |
| icon | De pictogramrepresentatie van de weerconditie. |
| windSpeed | De windsnelheid op de locatie. |
| windDirection | De windrichting in graden op de locatie. |
| pressure | De luchtdruk op de locatie. |
| humidity | De luchtvochtigheid op de locatie. |
| visibility | Het zicht op de locatie. |
| uv | De UV-index op de locatie. |

## Constructors

| | |
|---|---|
| [LocatieInfo](-locatie-info.md) | [androidJvm]<br>constructor(placeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), temp: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), feelsLike: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), windSpeed: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), windDirection: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), pressure: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), visibility: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), uv: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [feelsLike](feels-like.md) | [androidJvm]<br>var [feelsLike](feels-like.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [humidity](humidity.md) | [androidJvm]<br>var [humidity](humidity.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [icon](icon.md) | [androidJvm]<br>var [icon](icon.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [placeName](place-name.md) | [androidJvm]<br>var [placeName](place-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [pressure](pressure.md) | [androidJvm]<br>var [pressure](pressure.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [temp](temp.md) | [androidJvm]<br>var [temp](temp.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [uv](uv.md) | [androidJvm]<br>var [uv](uv.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [visibility](visibility.md) | [androidJvm]<br>var [visibility](visibility.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [windDirection](wind-direction.md) | [androidJvm]<br>var [windDirection](wind-direction.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [windSpeed](wind-speed.md) | [androidJvm]<br>var [windSpeed](wind-speed.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |

## Functions

| Name | Summary |
|---|---|
| [asDbWeatherLocation](../../com.example.myweatherapplication.data.database/as-db-weather-location.md) | [androidJvm]<br>fun [LocatieInfo](index.md).[asDbWeatherLocation](../../com.example.myweatherapplication.data.database/as-db-weather-location.md)(): [dbLocatieInfo](../../com.example.myweatherapplication.data.database/db-locatie-info/index.md)<br>Extensiefunctie om een [LocatieInfo](index.md)-object om te zetten naar een [dbLocatieInfo](../../com.example.myweatherapplication.data.database/db-locatie-info/index.md)-object. |
