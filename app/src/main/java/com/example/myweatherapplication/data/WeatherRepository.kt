package com.example.myweatherapplication.data

import com.example.myweatherapplication.data.database.LocatieInfoDao
import com.example.myweatherapplication.data.database.asDbWeatherLocation
import com.example.myweatherapplication.data.database.asDomainLocatieInfo
import com.example.myweatherapplication.data.database.asDomainLocatieInfoList
import com.example.myweatherapplication.ui.model.LocatieInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface WeatherRepository {
    fun getWeatherLocation(realLocation: String): Flow<LocatieInfo>


    fun getWeatherLocations(): Flow<List<LocatieInfo>>

    suspend fun insertWeatherLocation(locatieInfo: LocatieInfo)

    suspend fun deleteWeatherLocation(locatieInfo: LocatieInfo)

    suspend fun updateWeatherLocation(locatieInfo: LocatieInfo)
}

class OfflineWeatherRepository(private val locatieInfoDao:LocatieInfoDao
): WeatherRepository{
    override fun getWeatherLocation(realLocation: String): Flow<LocatieInfo> {
        return locatieInfoDao.getItem(realLocation).map{
            it.asDomainLocatieInfo()
        }
    }

    override fun getWeatherLocations(): Flow<List<LocatieInfo>> {
        return locatieInfoDao.getAllItems().map {
            it.asDomainLocatieInfoList()
        }
    }

    override suspend fun insertWeatherLocation(locatieInfo: LocatieInfo) {
        locatieInfoDao.insert(locatieInfo.asDbWeatherLocation())
    }

    override suspend fun deleteWeatherLocation(locatieInfo: LocatieInfo) {
        locatieInfoDao.delete(locatieInfo.asDbWeatherLocation())
    }

    override suspend fun updateWeatherLocation(locatieInfo: LocatieInfo) {
        locatieInfoDao.update(locatieInfo.asDbWeatherLocation())
    }

}