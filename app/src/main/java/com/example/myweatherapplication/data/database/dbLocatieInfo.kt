package com.example.myweatherapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myweatherapplication.ui.model.LocatieInfo

@Entity(tableName="locatie_info")
data class dbLocatieInfo(
    @PrimaryKey
    val placeName:String = "",
    val temp: Double = 0.0,
    val feelsLike: Double = 0.0,
    val icon:String = "",
    val windSpeed: Double = 0.0,
    val windDirection:Int = 0,
    val pressure: Double = 0.0,
    val humidity:Int = 0,
    val visibility: Double = 0.0,
    val uv: Double = 0.0
)

fun LocatieInfo.asDbWeatherLocation(): dbLocatieInfo {
    return dbLocatieInfo(
        placeName = this.placeName,
        temp = this.temp,
        feelsLike = this.feelsLike,
        icon = this.icon,
        windSpeed = this.windSpeed,
        windDirection = this.windDirection,
        pressure = this.pressure,
        humidity = this.humidity,
        visibility = this.visibility,
        uv = this.uv
    )
}

fun dbLocatieInfo.asDomainLocatieInfo(): LocatieInfo {
    return LocatieInfo(
        this.placeName,
        this.temp,
        this.feelsLike,
        this.icon,
        this.windSpeed,
        this.windDirection,
        this.pressure,
        this.humidity,
        this.visibility,
        this.uv
    )
}

fun List<dbLocatieInfo>.asDomainLocatieInfoList(): List<LocatieInfo>{
    var weatherLocationList = this.map {
        LocatieInfo(
            it.placeName,
            it.temp,
            it.feelsLike,
            it.icon,
            it.windSpeed,
            it.windDirection,
            it.pressure,
            it.humidity,
            it.visibility,
            it.uv)
    }
    return weatherLocationList
}