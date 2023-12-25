package com.example.myweatherapplication.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import com.example.myweatherapplication.ui.components.CreateTask
import com.example.myweatherapplication.ui.components.CurrentWeatherOverview
import com.example.myweatherapplication.ui.components.WeatherLocations
import com.example.myweatherapplication.ui.viewModel.HomeViewModel


/**
 * Composable die de navigatie van de app beheert en de bijbehorende schermen weergeeft.
 *
 * @param navController De [NavHostController] die de navigatie tussen schermen beheert.
 * @param innerPadding [PaddingValues] voor de lay-out.
 * @param isAddingVisible Geeft aan of het scherm voor het toevoegen van een locatie zichtbaar is.
 * @param makeInvisible Functie om het toevoegscherm onzichtbaar te maken.
 * @param homeViewModel [HomeViewModel] voor het beheer van de hoofdweergave van het weer.
 */
@Composable
fun Navigation(navController: NavHostController, innerPadding:PaddingValues, isAddingVisible:Boolean, makeInvisible : ()->Unit, homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)){
    val uiState by homeViewModel.uiState.collectAsState()

    val goToClickedLocation: (locatie:String)-> Unit = {
        homeViewModel.setChosenLocation(it)
        navController.navigate(WeatherOverviewScreen.Detail.name)
    }

    fun scaleIntoContainer(
        direction: ScaleTransitionDirection = ScaleTransitionDirection.INWARDS,
        initialScale: Float = if (direction == ScaleTransitionDirection.OUTWARDS) 0.9f else 1.1f
    ): EnterTransition {
        return scaleIn(
            animationSpec = tween(1500, delayMillis = 50),
            initialScale = initialScale
        ) + fadeIn(animationSpec = tween(1500, delayMillis = 50))
    }

    fun scaleOutOfContainer(
        direction: ScaleTransitionDirection = ScaleTransitionDirection.OUTWARDS,
        targetScale: Float = if (direction == ScaleTransitionDirection.INWARDS) 0.9f else 1.1f
    ): ExitTransition {
        return scaleOut(
            animationSpec = tween(
                durationMillis = 1500,
                delayMillis = 50
            ), targetScale = targetScale
        ) + fadeOut(tween(delayMillis = 50))
    }



    if(isAddingVisible){
        CreateTask(
            weatherLocationName = uiState.newLocationName,
            onWeatherLocationNameChanged = {homeViewModel.setNewLocationName(it)},
            onWeatherLocationSave = {
                val result = homeViewModel.saveNewLocation()
                when (result) {
                    is HomeViewModel.SaveLocationResult.Success -> {
                        // Navigeer alleen als de locatie succesvol werd opgeslagen
                        goToClickedLocation(result.loc)
                        homeViewModel.resetNewLocation()
                        makeInvisible()
                    }
                    is HomeViewModel.SaveLocationResult.Error -> {

                    }
                }
            },
            onDismissRequest = { makeInvisible(); homeViewModel.resetNewLocation() },
            errorMessage = uiState.errorMessage)
    }


    NavHost(
        navController = navController,
        startDestination = WeatherOverviewScreen.Start.name,
        modifier = Modifier.padding(innerPadding),
    ) {
        composable(route = WeatherOverviewScreen.Start.name,
            enterTransition = {
            scaleIntoContainer()
        },
            exitTransition = {
                scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
            },
            popEnterTransition = {
                scaleIntoContainer(direction = ScaleTransitionDirection.OUTWARDS)
            },
            popExitTransition = {
                scaleOutOfContainer()
            }) {

                CurrentWeatherOverview(modifier = Modifier.animateContentSize(), location = "Gent")
        }
        composable(route = WeatherOverviewScreen.List.name,
            enterTransition = {
                scaleIntoContainer()
            },
            exitTransition = {
                scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
            },
            popEnterTransition = {
                scaleIntoContainer(direction = ScaleTransitionDirection.OUTWARDS)
            },
            popExitTransition = {
                scaleOutOfContainer()
            }) {
            WeatherLocations(modifier = Modifier, goToClickedLocation)
        }
        composable(route = WeatherOverviewScreen.Detail.name,
            enterTransition = {
            scaleIntoContainer()
        },
            exitTransition = {
                scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
            },
            popEnterTransition = {
                scaleIntoContainer(direction = ScaleTransitionDirection.OUTWARDS)
            },
            popExitTransition = {
                scaleOutOfContainer()
            }){
            CurrentWeatherOverview(modifier = Modifier, location = uiState.chosenLocation)
        }
    }
}

/**
 * Enumeratie van richtingen voor de schaalovergang.
 */
enum class ScaleTransitionDirection {
    INWARDS,
    OUTWARDS
}