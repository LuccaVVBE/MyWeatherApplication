package com.example.myweatherapplication.ui.viewModel

/**
 * Representeert de staat van het startscherm in de weer-applicatie.
 *
 * @property chosenLocation De naam van de momenteel gekozen weerlocatie.
 * @property newLocationName De naam van een nieuwe locatie die wordt toegevoegd.
 * @property errorMessage Een bericht dat eventuele fouten aangeeft die zijn opgetreden tijdens het toevoegen van de locatie.
 */
data class HomeState(
    val chosenLocation : String="",
    val newLocationName: String = "",
    val errorMessage: String= ""
)
