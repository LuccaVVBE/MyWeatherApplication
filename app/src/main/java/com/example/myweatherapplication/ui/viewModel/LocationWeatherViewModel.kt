package com.example.myweatherapplication.ui.viewModel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.myweatherapplication.ui.model.LocatieInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocationWeatherViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(CurrentWeatherState())
    val uiState: StateFlow<CurrentWeatherState> = _uiState.asStateFlow()
    
}