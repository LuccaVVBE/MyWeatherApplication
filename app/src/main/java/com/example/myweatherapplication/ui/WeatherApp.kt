    package com.example.myweatherapplication.ui



import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myweatherapplication.R
import com.example.myweatherapplication.ui.components.NavigationDrawerContent
import com.example.myweatherapplication.ui.components.WeatherAppAppBar
import com.example.myweatherapplication.ui.components.WeatherBottomAppBar
import com.example.myweatherapplication.ui.components.WeatherNavigationRail
import com.example.myweatherapplication.ui.components.WeatherTopAppBar
import com.example.myweatherapplication.ui.navigation.Navigation
import com.example.myweatherapplication.ui.util.WeatherNavigationType

    /**
     * Hoofdcomposable voor de weer-app.
     *
     * @param navigationType [WeatherNavigationType] voor type navigatiebalk binnen de app.
     * @param navController [NavHostController] voor navigatie binnen de app.
     */
@Composable
fun WeatherApp(navigationType: WeatherNavigationType, navController: NavHostController = rememberNavController()) {


        val backStackEntry by navController.currentBackStackEntryAsState()
        var isAddingVisible by remember {
            mutableStateOf(false)
        }


        val showAddLocation: () -> Unit = {
            isAddingVisible = !isAddingVisible
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

        val goToList =
            { navController.navigate(WeatherOverviewScreen.List.name) { launchSingleTop = true } }

        if (navigationType == WeatherNavigationType.PERMANENT_NAVIGATION_DRAWER) {
            PermanentNavigationDrawer(drawerContent = {
                PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {

                    NavigationDrawerContent(
                        selectedDestination = navController.currentDestination,
                        onTabPressed = { node: String -> navController.navigate(node) {launchSingleTop=true} },
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(dimensionResource(R.dimen.drawer_padding_content))
                    )
                }
            }) {
                Scaffold(
                    containerColor = Color.Transparent,
                    topBar = {
                        WeatherTopAppBar(
                            canNavigateBack = canNavigateBack,
                            navigateUp = navigateUp,
                            currentScreenTitle = currentScreenTitle,
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { showAddLocation() },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) {
                            Icon(Icons.Filled.Add, "Nieuwe locatie")
                        }
                    },

                    ) { innerPadding ->
                    Navigation(
                        navController,
                        innerPadding,
                        isAddingVisible,
                        makeInvisible = { isAddingVisible = false })
                }
            }
        } else if (navigationType == WeatherNavigationType.BOTTOM_NAVIGATION) {
            Scaffold(
                containerColor = Color.Transparent,
                topBar = {
                    WeatherAppAppBar(
                        canNavigateBack = canNavigateBack,
                        navigateUp = navigateUp,
                        currentScreenTitle = currentScreenTitle,
                    )
                },
                bottomBar = {

                    WeatherBottomAppBar(goHome, goToList, showAddLocation)
                }
            ) { innerPadding ->
                Navigation(navController, innerPadding, isAddingVisible, showAddLocation)
            }
        } else {
            Row {
                AnimatedVisibility(visible = navigationType == WeatherNavigationType.NAVIGATION_RAIL) {
                    val navigationRailContentDescription = stringResource(R.string.navigation_rail)
                    WeatherNavigationRail(
                        selectedDestination = navController.currentDestination,
                        onTabPressed = { node: String -> navController.navigate(node) {launchSingleTop = true} },
                    )
                }
                Scaffold(
                    containerColor = Color.Transparent,
                    topBar = {
                        WeatherAppAppBar(
                            canNavigateBack = canNavigateBack,
                            navigateUp = navigateUp,
                            currentScreenTitle = currentScreenTitle,
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { showAddLocation() }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    },
                ) { innerPadding ->

                    Navigation(navController, innerPadding, isAddingVisible, showAddLocation)
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun WeatherAppPreview() {
    WeatherApp(WeatherNavigationType.BOTTOM_NAVIGATION)
}

