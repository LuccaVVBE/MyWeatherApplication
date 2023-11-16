package com.example.myweatherapplication.ui.viewModel;

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeState())
    val uiState : StateFlow<HomeState> = _uiState.asStateFlow()

    fun setChosenLocation(locatie:String){
        _uiState.update {
            it.copy(chosenLocation = locatie)
        }
    }
}
