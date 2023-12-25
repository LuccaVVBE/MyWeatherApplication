//[app](../../../index.md)/[com.example.myweatherapplication.data.database](../index.md)/[dbLocatieInfo](index.md)

# dbLocatieInfo

[androidJvm]\
data class [dbLocatieInfo](index.md)(val placeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val temp: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val feelsLike: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val windSpeed: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val windDirection: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val pressure: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val visibility: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, val uv: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0)

Representeert een dataklasse voor het opslaan van locatiegerelateerde informatie in de lokale Room-database.

## Constructors

| | |
|---|---|
| [dbLocatieInfo](db-locatie-info.md) | [androidJvm]<br>constructor(placeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, temp: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, feelsLike: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, icon: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, windSpeed: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, windDirection: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, pressure: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, visibility: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0, uv: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0) |

## Properties

| Name | Summary |
|---|---|
| [feelsLike](feels-like.md) | [androidJvm]<br>val [feelsLike](feels-like.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>De &quot;gevoelstemperatuur&quot; op de locatie. |
| [humidity](humidity.md) | [androidJvm]<br>val [humidity](humidity.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>De luchtvochtigheid op de locatie. |
| [icon](icon.md) | [androidJvm]<br>val [icon](icon.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Het pictogram dat het weer vertegenwoordigt. |
| [placeName](place-name.md) | [androidJvm]<br>val [placeName](place-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>De naam van de locatie. |
| [pressure](pressure.md) | [androidJvm]<br>val [pressure](pressure.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>De atmosferische druk op de locatie. |
| [temp](temp.md) | [androidJvm]<br>val [temp](temp.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>De temperatuur op de locatie. |
| [uv](uv.md) | [androidJvm]<br>val [uv](uv.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>De UV-index op de locatie. |
| [visibility](visibility.md) | [androidJvm]<br>val [visibility](visibility.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>Het zicht op de locatie. |
| [windDirection](wind-direction.md) | [androidJvm]<br>val [windDirection](wind-direction.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>De windrichting op de locatie. |
| [windSpeed](wind-speed.md) | [androidJvm]<br>val [windSpeed](wind-speed.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) = 0.0<br>De windsnelheid op de locatie. |

## Functions

| Name | Summary |
|---|---|
| [asDomainLocatieInfo](../as-domain-locatie-info.md) | [androidJvm]<br>fun [dbLocatieInfo](index.md).[asDomainLocatieInfo](../as-domain-locatie-info.md)(): [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md)<br>Extensiefunctie om een [dbLocatieInfo](index.md)-object om te zetten naar een [LocatieInfo](../../com.example.myweatherapplication.ui.model/-locatie-info/index.md)-object. |
