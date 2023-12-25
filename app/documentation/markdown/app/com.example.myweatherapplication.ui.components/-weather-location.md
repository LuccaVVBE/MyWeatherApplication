//[app](../../index.md)/[com.example.myweatherapplication.ui.components](index.md)/[WeatherLocation](-weather-location.md)

# WeatherLocation

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [WeatherLocation](-weather-location.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html), goToClickedLocation: (locatie: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), locatie: [LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md))

Composable voor het weergeven van individuele weerlocatie-informatie in de lijst.

#### Parameters

androidJvm

| | |
|---|---|
| modifier | De [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) die wordt toegepast op de composable. |
| goToClickedLocation | Callback-functie voor het navigeren naar een gekozen locatie. |
| locatie | [LocatieInfo](../com.example.myweatherapplication.ui.model/-locatie-info/index.md) met informatie over de weerlocatie. |
