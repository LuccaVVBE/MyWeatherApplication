package com.example.myweatherapplication.ui.viewModel

data class CurrentWeatherState(
    var temp:Int = 15,
    var icon:String = "",
    var windSpeed:Int = 14,
    var windDirection:Int = 210,
    var pressure:Int = 1013,
    var humidity:Int = 60,
    var visibility:Int = 15,
    var uv: Int = 2
)
