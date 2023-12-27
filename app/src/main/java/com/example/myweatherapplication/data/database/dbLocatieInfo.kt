package com.example.myweatherapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myweatherapplication.ui.model.LocatieInfo

/**
 * Representeert een dataklasse voor het opslaan van locatiegerelateerde informatie in de lokale Room-database.
 *
 * @property placeName De naam van de locatie.
 * @property temp De temperatuur op de locatie.
 * @property feelsLike De "gevoelstemperatuur" op de locatie.
 * @property icon Het pictogram dat het weer vertegenwoordigt.
 * @property windSpeed De windsnelheid op de locatie.
 * @property windDirection De windrichting op de locatie.
 * @property pressure De atmosferische druk op de locatie.
 * @property humidity De luchtvochtigheid op de locatie.
 * @property visibility Het zicht op de locatie.
 * @property uv De UV-index op de locatie.
 */
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

/**
 * Extensiefunctie om een [LocatieInfo]-object om te zetten naar een [dbLocatieInfo]-object.
 *
 * @return De [dbLocatieInfo]-representatie van het [LocatieInfo]-object.
 */
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

/**
 * Extensiefunctie om een [dbLocatieInfo]-object om te zetten naar een [LocatieInfo]-object.
 *
 * @return De [LocatieInfo]-representatie van het [dbLocatieInfo]-object.
 */
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

/**
 * Extensiefunctie om een lijst van [dbLocatieInfo]-objecten om te zetten naar een lijst van [LocatieInfo]-objecten.
 *
 * @return De lijst van [LocatieInfo]-representatie van de lijst van [dbLocatieInfo]-objecten.
 */
fun List<dbLocatieInfo>.asDomainLocatieInfoList(): List<LocatieInfo>{
    val weatherLocationList = this.map {
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