package com.example.myweatherapplication.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myweatherapplication.ui.WeatherOverviewScreen
import com.example.myweatherapplication.ui.components.CurrentWeatherOverview
import com.example.myweatherapplication.ui.components.WeatherLocations
import com.example.myweatherapplication.ui.viewModel.HomeViewModel

@Composable
fun Navigation(navController: NavHostController, innerPadding:PaddingValues, homeViewModel: HomeViewModel = viewModel()){
    val uiState by homeViewModel.uiState.collectAsState()

    val goToClickedLocation: (locatie:String)-> Unit = {
        homeViewModel.setChosenLocation(it)
        navController.navigate(WeatherOverviewScreen.Detail.name)
    }


    NavHost(
        navController = navController,
        startDestination = WeatherOverviewScreen.Start.name,
        modifier = androidx.compose.ui.Modifier.padding(innerPadding),
    ) {
        composable(route = WeatherOverviewScreen.Start.name) {
            CurrentWeatherOverview(modifier = Modifier)
        }
        composable(route = WeatherOverviewScreen.List.name) {
            WeatherLocations(modifier = Modifier, goToClickedLocation)
        }
        composable(route = WeatherOverviewScreen.Detail.name){
            CurrentWeatherOverview(modifier = Modifier, location = uiState.chosenLocation)
        }
    }
}