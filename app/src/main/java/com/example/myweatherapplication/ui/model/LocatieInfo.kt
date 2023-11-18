package com.example.myweatherapplication.ui.model

data class LocatieInfo(
    var placeName:String,
    var temp: Double,
    var feelsLike: Double,
    var icon:String,
    var windSpeed: Double,
    var windDirection:Int,
    var pressure: Double,
    var humidity:Int,
    var visibility: Double,
    var uv: Double
)
