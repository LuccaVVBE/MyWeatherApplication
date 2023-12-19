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
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LocationWeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(CurrentWeatherState())
    lateinit var uiListState: StateFlow<WeatherLocationListState>
    val uiState: StateFlow<CurrentWeatherState> = _uiState.asStateFlow();


    var weatherApiState: WeatherApiState by mutableStateOf(WeatherApiState.Loading)
        private set

    init {
        getRepoWeatherLocations()
    }


    //    fun getApiWeather(realLocation: String) {
//        viewModelScope.launch {
//            try{
//                //use the repository
//                //val weatherRepoitory = ApiWeatherRepository() //repo is now injected
//                val weatherInfo = weatherRepository.getWeatherLocation(realLocation)
//                _uiState.update {
//                    it.copy(locatieInfo = weatherInfo)
//                }
//                weatherApiState = WeatherApiState.Success
//            }
//            catch(e:Exception){
//                println(e.message)
//                println(e.localizedMessage)
//            }
//            catch (e: IOException){
//                //show a toast? save a log on firebase? ...
//                //set the error state
//                weatherApiState = WeatherApiState.Error
//            }
    fun getRepoWeatherLocations() {
        try {
            uiListState =
                weatherRepository.getWeatherLocations().map { WeatherLocationListState(it) }
                    .stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.WhileSubscribed(5000L),
                        initialValue = WeatherLocationListState()
                    )
            weatherApiState = WeatherApiState.Success
        } catch (e: Exception) {
            weatherApiState = WeatherApiState.Error
        }
    }

    fun getRepoWeatherLocation(location: String) {
        weatherApiState = WeatherApiState.Loading
        viewModelScope.launch {
            try {

                System.out.println("I ran my coroutine scope")

                // Perform the refresh only if the data is not in loading state
                weatherRepository.refresh(location)

                // Set the API state to success after successful data retrieval
                weatherApiState = WeatherApiState.Success

            } catch (e: Exception) {
                // Set the API state to error in case of an exception
                weatherApiState = WeatherApiState.Error
            } finally {
                // Fetch the location information
                val loc = weatherRepository.getWeatherLocation(location).first()

                // Update the UI state with the fetched location information
                _uiState.update {
                    it.copy(locatieInfo = loc)
                }
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

                LocationWeatherViewModel(
                    weatherRepository = weatherRepository,
                )
            }
        }
    }
}
