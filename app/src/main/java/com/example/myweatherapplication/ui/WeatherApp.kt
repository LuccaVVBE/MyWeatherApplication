package com.example.myweatherapplication.ui



import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myweatherapplication.ui.components.CurrentWeatherOverview
import com.example.myweatherapplication.ui.components.WeatherBottomAppBar
import com.example.myweatherapplication.ui.components.WeatherLocations
import com.example.myweatherapplication.ui.components.WeatherTopAppBar

@Composable
fun WeatherApp(navController: NavHostController = rememberNavController()) {

    val backStackEntry by navController.currentBackStackEntryAsState()

    val canNavigateBack = navController.previousBackStackEntry != null
    val navigateUp: () -> Unit = { navController.navigateUp() }
    val goHome: () -> Unit = {
        navController.popBackStack(
            WeatherOverviewScreen.Start.name,
            inclusive = false,
        )
    }

    val currentScreenTitle = WeatherOverviewScreen.valueOf(
        backStackEntry?.destination?.route ?: WeatherOverviewScreen.Start.name,
    ).title

    val goToList = { navController.navigate(WeatherOverviewScreen.List.name) }

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            WeatherTopAppBar(
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,
                currentScreenTitle = currentScreenTitle,
            )
        },
        bottomBar = {
            WeatherBottomAppBar(goHome, goToList)
        },

    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = WeatherOverviewScreen.Start.name,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(route = WeatherOverviewScreen.Start.name) {
                CurrentWeatherOverview(modifier = Modifier)
            }
            composable(route = WeatherOverviewScreen.List.name) {
                WeatherLocations(modifier = Modifier)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun WeatherAppPreview() {
    WeatherApp()
}

