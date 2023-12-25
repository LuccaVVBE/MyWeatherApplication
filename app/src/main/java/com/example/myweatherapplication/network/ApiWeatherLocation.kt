package com.example.myweatherapplication.network

import com.example.myweatherapplication.ui.model.LocatieInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

/**
 * Dataklasse voor het representen van weerlocatie-informatie van de externe API.
 *
 * @property location De [ApiWeatherLocation] die de locatiegegevens bevat.
 * @property current De [ApiWeatherCurrent] die de huidige weerinformatie bevat.
 */
@Serializable()
data class ApiWeatherLocationInfo(val location:ApiWeatherLocation,
                                  val current: ApiWeatherCurrent,
)

/**
 * Dataklasse voor het representen van locatiegegevens van de externe API.
 *
 * @property name De naam van de locatie.
 */
@Serializable
data class ApiWeatherLocation(
    val name:String
)

/**
 * Dataklasse voor het representen van huidige weerinformatie van de externe API.
 *
 * @property temp_c De temperatuur in graden Celsius.
 * @property feelslike_c De "gevoelstemperatuur" in graden Celsius.
 * @property condition De [ApiWeatherCurrentCondition] die de huidige weersomstandigheden bevat.
 * @property wind_kph De windsnelheid in kilometer per uur.
 * @property wind_degree De windrichting in graden.
 * @property pressure_mb De atmosferische druk in millibar.
 * @property humidity De luchtvochtigheid in percentage.
 * @property cloud De bewolking in percentage.
 * @property vis_km Het zicht in kilometer.
 * @property uv De UV-index.
 */
@Serializable
data class ApiWeatherCurrent(
    val temp_c:Double,
    val feelslike_c:Double,
    val condition: ApiWeatherCurrentCondition,
    val wind_kph:Double,
    val wind_degree:Int,
    val pressure_mb:Double,
    val humidity:Int,
    val cloud:Int,
    val vis_km:Double,
    val uv: Double

)

/**
 * Dataklasse voor het representen van huidige weersomstandigheden van de externe API.
 *
 * @property icon Het pictogram dat de weerconditie weergeeft.
 */
@Serializable
data class ApiWeatherCurrentCondition(
    val icon: String
)

/**
 * Extensiefunctie voor een [Flow] van [ApiWeatherLocationInfo] om deze om te zetten naar een [Flow] van [LocatieInfo].
 *
 * @return Een [Flow] van [LocatieInfo] die overeenkomt met de gegevens van de externe API.
 */
fun Flow<ApiWeatherLocationInfo>.asDomainObject(): Flow<LocatieInfo> {

    return this.map {
        LocatieInfo(
            it.location.name,
            it.current.temp_c,
            it.current.feelslike_c,
            it.current.condition.icon,
            it.current.wind_kph,
            it.current.wind_degree,
            it.current.pressure_mb,
            it.current.humidity,
            it.current.vis_km,
            it.current.uv
        )
    }
}