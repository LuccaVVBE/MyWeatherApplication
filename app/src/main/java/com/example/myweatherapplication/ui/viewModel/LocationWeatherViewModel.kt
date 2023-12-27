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
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel voor het beheren van de status van het locatieweerscherm.
 *
 * @param weatherRepository Repository voor het verkrijgen van weergegevens.
 */
class LocationWeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(CurrentWeatherState())
    lateinit var uiListState: StateFlow<WeatherLocationListState>
    val uiState: StateFlow<CurrentWeatherState> = _uiState.asStateFlow();

    /**
     * Vertegenwoordigt de status van de weer-API.
     */
    var weatherApiState: WeatherApiState by mutableStateOf(WeatherApiState.Loading)
        private set

    init {
        getRepoWeatherLocations()
    }

    /**
     * Haalt de lijst met weergegevens op uit de repository.
     */
    fun getRepoWeatherLocations() {
        try {

                val locations = weatherRepository.getWeatherLocations()
                    uiListState = locations.map { WeatherLocationListState(it) }
                    .stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.WhileSubscribed(5000L),
                        initialValue = WeatherLocationListState()
                    )
            weatherApiState = WeatherApiState.Success
        } catch (e: Exception) {
            weatherApiState = WeatherApiState.Error("Error: ".plus(e.localizedMessage))
        }
    }

    /**
     * Haalt de weergegevens op voor een specifieke locatie uit de repository.
     *
     * @param location De locatie waarvoor weergegevens worden aangevraagd.
     */
    fun getRepoWeatherLocation(location: String) {
        var isError = false;
        weatherApiState = WeatherApiState.Loading
        viewModelScope.launch {
            try {

                // Vernieuw de weergegevens voor de opgegeven locatie
                weatherRepository.refresh(location)

                // Stel de API-status in op succes na succesvolle gegevensopvraging
                weatherApiState = WeatherApiState.Success



            } catch (e: Exception) {
                // Stel de API-status in op fout in geval van een exception
                weatherApiState = if(e.localizedMessage?.contains("host")==true)
                    WeatherApiState.Error("Error: ".plus("No internet connection"))
                else
                    WeatherApiState.Error("Error: ".plus(e.localizedMessage))
                isError = true;
            } finally {

                val loc = weatherRepository.getWeatherLocation(location).firstOrNull()

                if(loc !=null) {
                    //Werk de UI-status bij met de opgehaalde locatiegegevens, indien ze bestaan in de database.
                    _uiState.update {
                        it.copy(locatieInfo = loc)

                    }
                }
            }
        }
    }

    /**
     * Verwijdert een locatie uit de repository.
     *
     * @param location De locatie die moet worden verwijderd.
     */
    fun removeLocation(location:String){
        viewModelScope.launch {
            val loc = weatherRepository.getWeatherLocation(location)
            weatherRepository.deleteWeatherLocation(loc.first())
        }
    }


    // Companion object om het Android-framework te vertellen hoe het de ViewModel-parameter moet behandelen.
    companion object {
        /**
         * Factory voor het maken van een [LocationWeatherViewModel] met de juiste parameters.
         */
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
