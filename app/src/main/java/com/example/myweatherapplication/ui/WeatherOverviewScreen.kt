package com.example.myweatherapplication.ui

import androidx.annotation.StringRes
import com.example.myweatherapplication.R


enum class WeatherOverviewScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Detail(title = R.string.detail),
    List(title = R.string.list)
}
