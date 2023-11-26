package com.example.myweatherapplication.network

import com.example.myweatherapplication.ui.model.LocatieInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable

@Serializable()
data class ApiWeatherLocationInfo(val location:ApiWeatherLocation,
                                  val current: ApiWeatherCurrent,
)


@Serializable
data class ApiWeatherLocation(
    val name:String
)

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
@Serializable
data class ApiWeatherCurrentCondition(
    val icon: String
)

//extension function for an ApiWeatherLocation List to convert is to a Domain LocatieInfo List
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