package com.example.myweatherapplication.ui.viewModel

data class HomeState(
    val chosenLocation : String="",
    val newLocationName: String = "",
    val errorMessage: String= ""
)
