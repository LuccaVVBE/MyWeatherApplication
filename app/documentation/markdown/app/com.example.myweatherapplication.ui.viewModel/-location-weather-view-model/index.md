//[app](../../../index.md)/[com.example.myweatherapplication.ui.viewModel](../index.md)/[LocationWeatherViewModel](index.md)

# LocationWeatherViewModel

class [LocationWeatherViewModel](index.md)(weatherRepository: [WeatherRepository](../../com.example.myweatherapplication.data/-weather-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel voor het beheren van de status van het locatieweerscherm.

#### Parameters

androidJvm

| | |
|---|---|
| weatherRepository | Repository voor het verkrijgen van weergegevens. |

## Constructors

| | |
|---|---|
| [LocationWeatherViewModel](-location-weather-view-model.md) | [androidJvm]<br>constructor(weatherRepository: [WeatherRepository](../../com.example.myweatherapplication.data/-weather-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [uiListState](ui-list-state.md) | [androidJvm]<br>lateinit var [uiListState](ui-list-state.md): StateFlow&lt;[WeatherLocationListState](../-weather-location-list-state/index.md)&gt; |
| [uiState](ui-state.md) | [androidJvm]<br>val [uiState](ui-state.md): StateFlow&lt;[CurrentWeatherState](../-current-weather-state/index.md)&gt; |
| [weatherApiState](weather-api-state.md) | [androidJvm]<br>var [weatherApiState](weather-api-state.md): [WeatherApiState](../-weather-api-state/index.md)<br>Vertegenwoordigt de status van de weer-API. |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [getRepoWeatherLocation](get-repo-weather-location.md) | [androidJvm]<br>fun [getRepoWeatherLocation](get-repo-weather-location.md)(location: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Haalt de weergegevens op voor een specifieke locatie uit de repository. |
| [getRepoWeatherLocations](get-repo-weather-locations.md) | [androidJvm]<br>fun [getRepoWeatherLocations](get-repo-weather-locations.md)()<br>Haalt de lijst met weergegevens op uit de repository. |
| [removeLocation](remove-location.md) | [androidJvm]<br>fun [removeLocation](remove-location.md)(location: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Verwijdert een locatie uit de repository. |
