    package com.example.myweatherapplication.ui



import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myweatherapplication.ui.components.WeatherBottomAppBar
import com.example.myweatherapplication.ui.components.WeatherTopAppBar
import com.example.myweatherapplication.ui.navigation.Navigation

    /**
     * Hoofdcomposable voor de weer-app.
     *
     * @param navController [NavHostController] voor navigatie binnen de app.
     */
@Composable
fun WeatherApp(navController: NavHostController = rememberNavController()) {


    val backStackEntry by navController.currentBackStackEntryAsState()
    var isAddingVisible by remember {
        mutableStateOf(false)
    }



    val showAddLocation : ()->Unit = {
        isAddingVisible=!isAddingVisible
    }
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

    val goToList = { navController.navigate(WeatherOverviewScreen.List.name) {launchSingleTop = true} }


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
            WeatherBottomAppBar(goHome, goToList, { showAddLocation() })
        },

    ) { innerPadding ->
        Navigation(navController, innerPadding, isAddingVisible, makeInvisible = {isAddingVisible = false})
    }
}



@Preview(showBackground = true)
@Composable
fun WeatherAppPreview() {
    WeatherApp()
}

