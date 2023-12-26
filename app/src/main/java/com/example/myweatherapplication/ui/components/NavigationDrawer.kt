package com.example.myweatherapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import com.example.myweatherapplication.R
import com.example.myweatherapplication.ui.WeatherOverviewScreen

/**
 * Samenstelling voor de inhoud van de navigationdrawer.
 *
 * @param selectedDestination De momenteel geselecteerde navigatiebestemming.
 * @param onTabPressed Callback om tabbladselectie te verwerken.
 * @param modifier Modifier voor de [Column].
 */
@Composable
fun NavigationDrawerContent(
    selectedDestination: NavDestination?,
    onTabPressed: ((String) -> Unit),
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        for (navItem in WeatherOverviewScreen.values()) {
            NavigationDrawerItem(
                selected = selectedDestination?.route == navItem.name,
                label = {
                    Text(
                        text = navItem.name,
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.drawer_padding_header))
                    )
                },
                icon = {

                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.name
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onTabPressed(navItem.name) }
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(bitmap = ImageBitmap.imageResource(R.drawable.weatherlogo), "", Modifier.size(128.dp).align(Alignment.CenterHorizontally) )
    }
}