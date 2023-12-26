package com.example.myweatherapplication.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myweatherapplication.R

/**
 * Enumeratie van schermen in de weer-applicatie.
 *
 * @property title Resource ID van de titel van het scherm.
 * @property icon Icon dat getoond kan worden in de navigationbar
 */
enum class WeatherOverviewScreen(@StringRes val title: Int, val icon: ImageVector) {
    Start(title = R.string.Homescreen, Icons.Filled.Home),
    List(title = R.string.List, Icons.Filled.List),
    Detail(title = R.string.detail, Icons.Filled.Search)
}
