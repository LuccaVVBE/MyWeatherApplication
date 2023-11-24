package com.example.myweatherapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="locatie_info")
data class dbLocatieInfo(
    @PrimaryKey(autoGenerate=true)
    val placeid:Int,
    val placeName:String,
    val temp: Double,
    val feelsLike: Double,
    val icon:String,
    val windSpeed: Double,
    val windDirection:Int,
    val pressure: Double,
    val humidity:Int,
    val visibility: Double,
    val uv: Double
)