package com.example.myweatherapplication.ui

import androidx.annotation.StringRes
import com.example.myweatherapplication.R

/**
 * Enumeratie van schermen in de weer-applicatie.
 *
 * @property title Resource ID van de titel van het scherm.
 */
enum class WeatherOverviewScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Detail(title = R.string.detail),
    List(title = R.string.List)
}
