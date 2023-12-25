//[app](../../../index.md)/[com.example.myweatherapplication.ui.viewModel](../index.md)/[HomeViewModel](index.md)

# HomeViewModel

class [HomeViewModel](index.md)(weatherRepository: [WeatherRepository](../../com.example.myweatherapplication.data/-weather-repository/index.md)) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel voor het beheren van de staat van de Home Screen.

#### Parameters

androidJvm

| | |
|---|---|
| weatherRepository | Repository voor het verkrijgen van weergegevens. |

## Constructors

| | |
|---|---|
| [HomeViewModel](-home-view-model.md) | [androidJvm]<br>constructor(weatherRepository: [WeatherRepository](../../com.example.myweatherapplication.data/-weather-repository/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
| [SaveLocationResult](-save-location-result/index.md) | [androidJvm]<br>sealed class [SaveLocationResult](-save-location-result/index.md)<br>Resultaat van het opslaan van een nieuwe locatie. |

## Properties

| Name | Summary |
|---|---|
| [uiState](ui-state.md) | [androidJvm]<br>val [uiState](ui-state.md): StateFlow&lt;[HomeState](../-home-state/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../-location-weather-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../-location-weather-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [capitalizeWords](capitalize-words.md) | [androidJvm]<br>fun [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).[capitalizeWords](capitalize-words.md)(delimiter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot; &quot;): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Zet de eerste letter van elk woord met een hoofdletter. |
| [resetNewLocation](reset-new-location.md) | [androidJvm]<br>fun [resetNewLocation](reset-new-location.md)()<br>Reset de nieuwe locatienaam en foutmelding in de UI-staat. |
| [saveNewLocation](save-new-location.md) | [androidJvm]<br>fun [saveNewLocation](save-new-location.md)(): [HomeViewModel.SaveLocationResult](-save-location-result/index.md)<br>Slaat de nieuwe locatie op en geeft het resultaat terug. |
| [setChosenLocation](set-chosen-location.md) | [androidJvm]<br>fun [setChosenLocation](set-chosen-location.md)(locatie: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Zet de gekozen locatie in de UI-staat. |
| [setNewLocationName](set-new-location-name.md) | [androidJvm]<br>fun [setNewLocationName](set-new-location-name.md)(locationName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Capitalizeert de woorden in de locatienaam en zet deze in de UI-staat. |
