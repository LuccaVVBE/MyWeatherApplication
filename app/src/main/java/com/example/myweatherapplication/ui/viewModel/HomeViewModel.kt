package com.example.myweatherapplication.ui.viewModel;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myweatherapplication.MyWeatherApplication
import com.example.myweatherapplication.data.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeState())
    val uiState : StateFlow<HomeState> = _uiState.asStateFlow()

    fun setChosenLocation(locatie:String){
        _uiState.update {
            it.copy(chosenLocation = locatie)
        }
    }

    fun setNewLocationName(locationName: String) {
        _uiState.update {
            it.copy(newLocationName = locationName)
        }
    }

    fun saveNewLocation() {
        viewModelScope.launch {
            weatherRepository.refresh(uiState.value.newLocationName)
            _uiState.update {
                it.copy(newLocationName = "")
            }
        }
    }

    //object to tell the android framework how to handle the parameter of the viewmodel
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyWeatherApplication)
                val weatherRepository = application.container.weatherRepository

                HomeViewModel(
                    weatherRepository = weatherRepository,
                )
            }
        }
    }

}
