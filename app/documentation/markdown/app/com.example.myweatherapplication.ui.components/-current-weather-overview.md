//[app](../../index.md)/[com.example.myweatherapplication.ui.components](index.md)/[CurrentWeatherOverview](-current-weather-overview.md)

# CurrentWeatherOverview

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [CurrentWeatherOverview](-current-weather-overview.md)(modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html), currentWeatherViewModel: [LocationWeatherViewModel](../com.example.myweatherapplication.ui.viewModel/-location-weather-view-model/index.md) = viewModel(factory = LocationWeatherViewModel.Factory), location: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;Gent&quot;, forceNavUp: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))

Composable voor het weergeven van het huidige weeroverzicht.

#### Parameters

androidJvm

| | |
|---|---|
| modifier | De [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) die wordt toegepast op de composable. |
| currentWeatherViewModel | Het [LocationWeatherViewModel](../com.example.myweatherapplication.ui.viewModel/-location-weather-view-model/index.md) om weerinformatie op te halen. |
| location | De naam van de locatie waarvan de weerinformatie moet worden weergegeven. |
| forceNavUp | De functie om terug naar boven te navigeren wanneer er eerder geen locatie geselecterd werd. |
