package com.example.myweatherapplication.ui



import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myweatherapplication.ui.components.WeatherBottomAppBar
import com.example.myweatherapplication.ui.components.WeatherTopAppBar
import com.example.myweatherapplication.ui.navigation.Navigation
import com.example.myweatherapplication.ui.viewModel.HomeViewModel

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
//todo: bring to different component
        Navigation(navController, innerPadding)
    }
}



@Preview(showBackground = true)
@Composable
fun WeatherAppPreview() {
    WeatherApp()
}

