package com.example.myweatherapplication.ui.viewModel

import com.example.myweatherapplication.data.WeatherRepository
import com.example.myweatherapplication.ui.model.LocatieInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

/*    @Test
    fun `test getRepoWeatherLocations success`() = runTest {
        // Mock the behavior of WeatherRepository
        val mockLocations = listOf(
            LocatieInfo("first", 0.0, 0.0, "", 0.0, 0, 0.0, 0, 0.0, 0.0),
            LocatieInfo("second", 0.0, 0.0, "", 0.0, 0, 0.0, 0, 0.0, 0.0)
        )
        Mockito.`when`(weatherRepository.getWeatherLocations()).thenAnswer {
            MutableStateFlow(
                mockLocations
            )
        }

        // Call the method you want to test
        locationWeatherViewModel.getRepoWeatherLocations()


        // Verify the expected state after the method call
        assertEquals(WeatherApiState.Success, locationWeatherViewModel.weatherApiState)
        assertEquals(mockLocations, locationWeatherViewModel.uiListState.value.weatherLocationList)
    }*/

    @Test
    fun `test getRepoWeatherLocations error`() = runTest {
        // Mock the behavior of WeatherRepository to throw an exception
        Mockito.`when`(weatherRepository.getWeatherLocations()).thenThrow(RuntimeException("Some error"))

        // Call the method you want to test
        locationWeatherViewModel.getRepoWeatherLocations()

        // Verify the expected state after the method call
        assertEquals(WeatherApiState.Error, locationWeatherViewModel.weatherApiState)
        // You might want to check other aspects of the state or behavior in case of an error
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
        Mockito.`when`(weatherRepository.refresh(locationName)).thenThrow(RuntimeException())
        val initialLoc = locationWeatherViewModel.uiState.value.locatieInfo
        // Call the method you want to test
        locationWeatherViewModel.getRepoWeatherLocation(locationName)

        // Verify the expected state after the method call
        assertEquals(WeatherApiState.Error, locationWeatherViewModel.weatherApiState)
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

class TestDispatcherRule(
    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
) : TestWatcher() {
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}