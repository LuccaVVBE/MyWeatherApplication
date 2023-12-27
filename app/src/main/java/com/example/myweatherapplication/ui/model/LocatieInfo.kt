package com.example.myweatherapplication.ui.model

/**
 * Dataklasse die de weergerelateerde informatie voor een locatie vertegenwoordigt.
 *
 * @param placeName De naam van de locatie.
 * @param temp De temperatuur op de locatie.
 * @param feelsLike De gevoelstemperatuur op de locatie.
 * @param icon De pictogramrepresentatie van de weerconditie.
 * @param windSpeed De windsnelheid op de locatie.
 * @param windDirection De windrichting in graden op de locatie.
 * @param pressure De luchtdruk op de locatie.
 * @param humidity De luchtvochtigheid op de locatie.
 * @param visibility Het zicht op de locatie.
 * @param uv De UV-index op de locatie.
 */
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
    var uv: Double,
)
