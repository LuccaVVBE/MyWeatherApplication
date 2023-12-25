//[app](../../../index.md)/[com.example.myweatherapplication.data](../index.md)/[DefaultAppContainer](index.md)

# DefaultAppContainer

[androidJvm]\
class [DefaultAppContainer](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [AppContainer](../-app-container/index.md)

Standaard implementatie van [AppContainer](../-app-container/index.md) die verantwoordelijk is voor het beheren van afhankelijkheden.

## Constructors

| | |
|---|---|
| [DefaultAppContainer](-default-app-container.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |

## Properties

| Name | Summary |
|---|---|
| [weatherRepository](weather-repository.md) | [androidJvm]<br>open override val [weatherRepository](weather-repository.md): [WeatherRepository](../-weather-repository/index.md)<br>De [WeatherRepository](../-weather-repository/index.md) die wordt gebruikt in de applicatie. |
