package com.example.myweatherapplication

import com.example.myweatherapplication.data.WeatherRepository
import com.example.myweatherapplication.ui.model.LocatieInfo
import com.example.myweatherapplication.ui.viewModel.LocationWeatherViewModel
import com.example.myweatherapplication.ui.viewModel.WeatherApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class LocationWeatherViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Mock
    private lateinit var weatherRepository: WeatherRepository

    private lateinit var locationWeatherViewModel: LocationWeatherViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        locationWeatherViewModel = LocationWeatherViewModel(weatherRepository)
    }

    @Test
    fun `test getRepoWeatherLocations success`() = runTest {
        //Mock
        Mockito.`when`(weatherRepository.getWeatherLocations()).thenReturn(flowOf())

        // Call the method you want to test
        locationWeatherViewModel.getRepoWeatherLocations()


        // Verify the expected state after the method call
        assertEquals(WeatherApiState.Success, locationWeatherViewModel.weatherApiState)
        assertEquals(listOf<LocatieInfo>(), locationWeatherViewModel.uiListState.value.weatherLocationList)
    }

    @Test
    fun `test getRepoWeatherLocations error`() = runTest {
        // Mock the behavior of WeatherRepository to throw an exception
        Mockito.`when`(weatherRepository.getWeatherLocations()).thenThrow(RuntimeException("Some error"))

        // Call the method you want to test
        locationWeatherViewModel.getRepoWeatherLocations()


        // Verify the expected state after the method call
        assertEquals(WeatherApiState.Error("Error: Some error"), locationWeatherViewModel.weatherApiState)
    }



    @Test
    fun `test getRepoWeatherLocation success`() = runTest {
        // Mock the behavior of WeatherRepository
        val mockLocation = LocatieInfo("TestLocation", 0.0, 0.0, "", 0.0, 0, 0.0, 0, 0.0, 0.0)
        Mockito.`when`(weatherRepository.refresh(Mockito.anyString())).thenReturn("Success")
        Mockito.`when`(weatherRepository.getWeatherLocation(Mockito.anyString())).thenReturn(flowOf(mockLocation))

        // Call the method you want to test
        locationWeatherViewModel.getRepoWeatherLocation("TestLocation")

        // Verify the expected state after the method call
        assertEquals(WeatherApiState.Success, locationWeatherViewModel.weatherApiState)
        assertEquals(mockLocation, locationWeatherViewModel.uiState.value.locatieInfo)
    }

    @Test
    fun `test getRepoWeatherLocation error`() = runTest {
        // Mock the behavior of WeatherRepository to throw an exception
        val locationName = "TestLocation"
        Mockito.`when`(weatherRepository.refresh(locationName)).thenThrow(RuntimeException("Some error"))
        Mockito.`when`(weatherRepository.getWeatherLocation(locationName)).thenReturn(flowOf())
        val initialLoc = locationWeatherViewModel.uiState.value.locatieInfo
        // Call the method you want to test
        locationWeatherViewModel.getRepoWeatherLocation(locationName)

        // Verify the expected state after the method call
        assertEquals(WeatherApiState.Error("Error: Some error"), locationWeatherViewModel.weatherApiState)
        // Ensure that locatieInfo remains unchanged when there is an error
        assertEquals(initialLoc, locationWeatherViewModel.uiState.value.locatieInfo)
    }

    @Test
    fun `test removeLocation`() = runTest {
        // Mock the behavior of WeatherRepository
        val mockLocation = LocatieInfo("TestLocation", 0.0, 0.0, "", 0.0, 0, 0.0, 0, 0.0, 0.0)
        Mockito.`when`(weatherRepository.getWeatherLocation(Mockito.anyString())).thenReturn(flowOf(mockLocation))

        // Call the method you want to test
        locationWeatherViewModel.removeLocation("TestLocation")

        // Verify that the deleteWeatherLocation method is called with the correct location
        Mockito.verify(weatherRepository).deleteWeatherLocation(mockLocation)
    }
}

