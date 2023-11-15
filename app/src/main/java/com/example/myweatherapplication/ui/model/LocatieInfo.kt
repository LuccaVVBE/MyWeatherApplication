package com.example.myweatherapplication.ui.model

data class LocatieInfo(
    var temp:Int,
    var icon:String,
    var windSpeed:Int,
    var windDirection:Int,
    var pressure:Int,
    var humidity:Int,
    var visibility:Int,
    var uv: Int
)
