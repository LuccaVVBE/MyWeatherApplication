package com.example.myweatherapplication.ui.model

data class LocatieInfo(
    var placeName:String,
    var temp: Number,
    var icon:String,
    var windSpeed:Int,
    var windDirection:Int,
    var pressure:Int,
    var humidity:Int,
    var visibility:Int,
    var uv: Int
)
