//[app](../../index.md)/[com.example.myweatherapplication.ui.navigation](index.md)/[Navigation](-navigation.md)

# Navigation

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [Navigation](-navigation.md)(navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html), innerPadding: [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html), isAddingVisible: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), makeInvisible: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), homeViewModel: [HomeViewModel](../com.example.myweatherapplication.ui.viewModel/-home-view-model/index.md) = viewModel(factory = HomeViewModel.Factory))

Composable die de navigatie van de app beheert en de bijbehorende schermen weergeeft.

#### Parameters

androidJvm

| | |
|---|---|
| navController | De [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html) die de navigatie tussen schermen beheert. |
| innerPadding | [PaddingValues](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/PaddingValues.html) voor de lay-out. |
| isAddingVisible | Geeft aan of het scherm voor het toevoegen van een locatie zichtbaar is. |
| makeInvisible | Functie om het toevoegscherm onzichtbaar te maken. |
| homeViewModel | [HomeViewModel](../com.example.myweatherapplication.ui.viewModel/-home-view-model/index.md) voor het beheer van de hoofdweergave van het weer. |
