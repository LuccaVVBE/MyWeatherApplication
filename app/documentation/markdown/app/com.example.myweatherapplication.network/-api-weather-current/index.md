//[app](../../../index.md)/[com.example.myweatherapplication.network](../index.md)/[ApiWeatherCurrent](index.md)

# ApiWeatherCurrent

[androidJvm]\
@Serializable

data class [ApiWeatherCurrent](index.md)(val temp_c: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val feelslike_c: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val condition: [ApiWeatherCurrentCondition](../-api-weather-current-condition/index.md), val wind_kph: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val wind_degree: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val pressure_mb: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val cloud: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val vis_km: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val uv: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))

Dataklasse voor het representen van huidige weerinformatie van de externe API.

## Constructors

| | |
|---|---|
| [ApiWeatherCurrent](-api-weather-current.md) | [androidJvm]<br>constructor(temp_c: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), feelslike_c: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), condition: [ApiWeatherCurrentCondition](../-api-weather-current-condition/index.md), wind_kph: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), wind_degree: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), pressure_mb: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), cloud: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), vis_km: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), uv: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [cloud](cloud.md) | [androidJvm]<br>val [cloud](cloud.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>De bewolking in percentage. |
| [condition](condition.md) | [androidJvm]<br>val [condition](condition.md): [ApiWeatherCurrentCondition](../-api-weather-current-condition/index.md)<br>De [ApiWeatherCurrentCondition](../-api-weather-current-condition/index.md) die de huidige weersomstandigheden bevat. |
| [feelslike_c](feelslike_c.md) | [androidJvm]<br>val [feelslike_c](feelslike_c.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>De &quot;gevoelstemperatuur&quot; in graden Celsius. |
| [humidity](humidity.md) | [androidJvm]<br>val [humidity](humidity.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>De luchtvochtigheid in percentage. |
| [pressure_mb](pressure_mb.md) | [androidJvm]<br>val [pressure_mb](pressure_mb.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>De atmosferische druk in millibar. |
| [temp_c](temp_c.md) | [androidJvm]<br>val [temp_c](temp_c.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>De temperatuur in graden Celsius. |
| [uv](uv.md) | [androidJvm]<br>val [uv](uv.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>De UV-index. |
| [vis_km](vis_km.md) | [androidJvm]<br>val [vis_km](vis_km.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Het zicht in kilometer. |
| [wind_degree](wind_degree.md) | [androidJvm]<br>val [wind_degree](wind_degree.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>De windrichting in graden. |
| [wind_kph](wind_kph.md) | [androidJvm]<br>val [wind_kph](wind_kph.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>De windsnelheid in kilometer per uur. |
