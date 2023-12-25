//[app](../../index.md)/[com.example.myweatherapplication.ui.components](index.md)/[CreateTask](-create-task.md)

# CreateTask

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [CreateTask](-create-task.md)(weatherLocationName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onWeatherLocationNameChanged: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onWeatherLocationSave: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onDismissRequest: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Composable voor het maken van een dialoogvenster voor het toevoegen van een nieuwe weerlocatie.

#### Parameters

androidJvm

| | |
|---|---|
| weatherLocationName | De naam van de weerlocatie. |
| onWeatherLocationNameChanged | De callback-functie die wordt aangeroepen wanneer de weerlocatienaam wordt gewijzigd. |
| onWeatherLocationSave | De callback-functie die wordt aangeroepen wanneer de gebruiker de weerlocatie opslaat. |
| onDismissRequest | De callback-functie die wordt aangeroepen wanneer het dialoogvenster wordt gesloten. |
| errorMessage | Het foutbericht dat moet worden weergegeven (indien aanwezig). |
