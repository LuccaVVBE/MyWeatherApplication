//[app](../../index.md)/[com.example.myweatherapplication.ui.components](index.md)/[WeatherTopAppBar](-weather-top-app-bar.md)

# WeatherTopAppBar

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [WeatherTopAppBar](-weather-top-app-bar.md)(canNavigateBack: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), navigateUp: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), currentScreenTitle: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))

Composable voor de topbar met weergerelateerde schermtitel en navigatieknoppen.

#### Parameters

androidJvm

| | |
|---|---|
| canNavigateBack | Geeft aan of de terugknop moet worden weergegeven (true) of verborgen (false). |
| navigateUp | Callback-functie voor het uitvoeren van de navigatie naar boven. |
| currentScreenTitle | Resource ID van de huidige schermtitel die moet worden weergegeven. |
