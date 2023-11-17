package com.example.myweatherapplication.network

import com.example.myweatherapplication.ui.model.LocatieInfo
import kotlinx.serialization.Serializable

@Serializable
data class ApiWeatherLocationInfo(val location:ApiWeatherLocation,
                                  val current: ApiWeatherCurrent,
                              )


@Serializable
data class ApiWeatherLocation(
    val name:String
)

@Serializable
data class ApiWeatherCurrent(
    val temp_c:Number,
    val condition: ApiWeatherCurrentCondition,
    val wind_kph:Int,
    val wind_degree:Int,
    val pressure_mb:Int,
    val humidity:Int,
    val cloud:Int,
    val vis_km:Int,
    val uv: Int

)
@Serializable
data class ApiWeatherCurrentCondition(
    val icon: String
)

//extension function for an ApiWeatherLocation List to convert is to a Domain LocatieInfo List
fun ApiWeatherLocationInfo.asDomainObject(): LocatieInfo {

    return LocatieInfo(location.name,
        current.temp_c,
        current.condition.icon,
        current.wind_kph,
        current.wind_degree,
        current.pressure_mb,
        current.humidity,
        current.vis_km,
        current.uv)
}