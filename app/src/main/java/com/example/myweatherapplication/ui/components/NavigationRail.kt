package com.example.myweatherapplication.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import com.example.myweatherapplication.ui.WeatherOverviewScreen

/**
 * Aangepaste [NavigationRail] voor alle navigatie.
 *
 * @param selectedDestination De huidige geselecteerde navigatiebestemming.
 * @param onTabPressed Callback om tabbladselectie te verwerken.
 * @param modifier Modifier voor de [NavigationRail].
 */
@Composable
fun WeatherNavigationRail(selectedDestination: NavDestination?, onTabPressed: (String) -> Unit, modifier : Modifier = Modifier) {
    NavigationRail(modifier = modifier) {
        for (navItem in WeatherOverviewScreen.values()) {
            NavigationRailItem(
                selected = selectedDestination?.route == navItem.name,
                onClick = { onTabPressed(navItem.name) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.name
                    )
                }
            )
        }
    }
}