package com.example.myweatherapplication.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myweatherapplication.MyWeatherApplication
import com.example.myweatherapplication.data.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class LocationWeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel(){
    private val _uiState = MutableStateFlow(CurrentWeatherState())
    val uiState: StateFlow<CurrentWeatherState> = _uiState.asStateFlow()


    var weatherApiState: WeatherApiState by mutableStateOf(WeatherApiState.Loading)
        private set

    fun getApiWeather(realLocation: String) {
        viewModelScope.launch {
            try{
                //use the repository
                //val tasksRepository = ApiTasksRepository() //repo is now injected
                val weatherInfo = weatherRepository.getWeatherLocation(realLocation)
                _uiState.update {
                    it.copy(locatieInfo = weatherInfo)
                }
                weatherApiState = WeatherApiState.Success(weatherInfo)
            }
            catch(e:Exception){
                println(e.message)
                println(e.localizedMessage)
                println("mslqkjflkmqdjmqlksjfmklqdsjfmlkqjfmlkj")
            }
            catch (e: IOException){
                //show a toast? save a log on firebase? ...
                //set the error state
                weatherApiState = WeatherApiState.Error
            }

        }
    }
    //object to tell the android framework how to handle the parameter of the viewmodel
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyWeatherApplication)
                val weatherRepository = application.container.weatherRepository

                LocationWeatherViewModel(weatherRepository = weatherRepository,
                )
            }
        }
    }
}