package com.example.myweatherapplication.ui.viewModel;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myweatherapplication.MyWeatherApplication
import com.example.myweatherapplication.data.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking

/**
 * ViewModel voor het beheren van de staat van de Home Screen.
 *
 * @param weatherRepository Repository voor het verkrijgen van weergegevens.
 */
class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    /**
     * Zet de gekozen locatie in de UI-staat.
     *
     * @param locatie De geselecteerde locatie.
     */
    fun setChosenLocation(locatie: String) {
        _uiState.update {
            it.copy(chosenLocation = locatie)
        }
    }

    /**
     * Zet de eerste letter van elk woord met een hoofdletter.
     *
     * @param delimter Aanduiding op welk karakter de string gesplitst wordt.
     */
    fun String.capitalizeWords(delimiter: String = " ") =
        split(delimiter).joinToString(delimiter) { word ->

            val smallCaseWord = word.lowercase()
            smallCaseWord.replaceFirstChar(Char::titlecaseChar)

        }

    /**
     * Capitalizeert de woorden in de locatienaam en zet deze in de UI-staat.
     *
     * @param locationName De locatienaam om te kapitaliseren.
     */
    fun setNewLocationName(locationName: String) {
        _uiState.update {
            it.copy(newLocationName = locationName.capitalizeWords())
        }
    }

    /**
     * Reset de nieuwe locatienaam en foutmelding in de UI-staat.
     */
    fun resetNewLocation() {
        _uiState.update {
            it.copy(newLocationName = "", errorMessage = "")

        }
    }


    /**
     * Resultaat van het opslaan van een nieuwe locatie.
     */
    sealed class SaveLocationResult {
        data class Success(val loc:String) : SaveLocationResult()
        object Error : SaveLocationResult()
    }

    /**
     * Slaat de nieuwe locatie op en geeft het resultaat terug.
     *
     * @return Het resultaat van het opslaan van de nieuwe locatie.
     */
    fun saveNewLocation(): SaveLocationResult {
        return try {
            runBlocking {
                SaveLocationResult.Success(weatherRepository.refresh(uiState.value.newLocationName));
            }
        } catch (e: Exception) {
            _uiState.update {
                it.copy(errorMessage = "Location could not be found, check the spelling again or your internet connection")
            }
            SaveLocationResult.Error
        }
    }

    // Companion object om het Android-framework te vertellen hoe het de ViewModel-parameter moet behandelen.
    companion object {
        /**
         * Factory voor het maken van een [HomeViewModel] met de juiste parameters.
         */
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
