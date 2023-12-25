//[app](../../index.md)/[com.example.myweatherapplication.ui.components](index.md)/[WeatherLocations](-weather-locations.md)

# WeatherLocations

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [WeatherLocations](-weather-locations.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html), goToClickedLocation: (locatie: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), locationWeatherViewModel: [LocationWeatherViewModel](../com.example.myweatherapplication.ui.viewModel/-location-weather-view-model/index.md) = viewModel(factory = LocationWeatherViewModel.Factory))

Composable voor het weergeven van de lijst met opgeslagen weerlocaties.

#### Parameters

androidJvm

| | |
|---|---|
| modifier | De [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) die wordt toegepast op de composable. |
| goToClickedLocation | Callback-functie voor het navigeren naar een gekozen locatie. |
| locationWeatherViewModel | [LocationWeatherViewModel](../com.example.myweatherapplication.ui.viewModel/-location-weather-view-model/index.md) die wordt gebruikt om de lijst met weerlocaties op te halen. |
