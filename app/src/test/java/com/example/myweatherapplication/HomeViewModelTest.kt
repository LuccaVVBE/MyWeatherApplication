package com.example.myweatherapplication

import com.example.myweatherapplication.data.WeatherRepository
import com.example.myweatherapplication.ui.viewModel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Mock
    private lateinit var weatherRepository: WeatherRepository

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        homeViewModel = HomeViewModel(weatherRepository)
    }

    @Test
    fun `test set chosen location`() = runTest {
        homeViewModel.setChosenLocation("TestLocation")
        assert(homeViewModel.uiState.value.chosenLocation == "TestLocation")
    }

    @Test
    fun `test set new location name`() = runTest {
        homeViewModel.setNewLocationName("test location")
        assert(homeViewModel.uiState.value.newLocationName == "Test Location")
    }

    @Test
    fun `test reset new location`() = runTest {
        homeViewModel.resetNewLocation()
        assert(homeViewModel.uiState.value.newLocationName == "")
        assert(homeViewModel.uiState.value.errorMessage == "")
    }

    @Test
    fun `test save new location success`() = runTest {
        val locationName = "Testlocation"
        Mockito.`when`(weatherRepository.refresh(locationName)).thenAnswer { locationName }
        homeViewModel.setNewLocationName(locationName = locationName)
        val result = homeViewModel.saveNewLocation()
        homeViewModel.resetNewLocation()

        assert(result is HomeViewModel.SaveLocationResult.Success)
        assert((result as HomeViewModel.SaveLocationResult.Success).loc == locationName)
        assert(homeViewModel.uiState.value.errorMessage.isBlank())
    }

    @Test
    fun `test save new location error`() = runTest {
        val locationName = "TestLocation"
        Mockito.`when`(weatherRepository.refresh(locationName)).thenThrow(RuntimeException())
        homeViewModel.setNewLocationName(locationName)
        val result = homeViewModel.saveNewLocation()

        assert(result is HomeViewModel.SaveLocationResult.Error)
        assert(homeViewModel.uiState.value.errorMessage.isNotBlank())
    }
}

