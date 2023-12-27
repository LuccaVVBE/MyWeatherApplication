package com.example.myweatherapplication.data

import com.example.myweatherapplication.data.database.LocatieInfoDao
import com.example.myweatherapplication.data.database.asDbWeatherLocation
import com.example.myweatherapplication.data.database.asDomainLocatieInfo
import com.example.myweatherapplication.data.database.asDomainLocatieInfoList
import com.example.myweatherapplication.network.WeatherApiService
import com.example.myweatherapplication.network.asDomainObject
import com.example.myweatherapplication.network.getWeatherLocationAsFlow
import com.example.myweatherapplication.ui.model.LocatieInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * Repository-interface voor het ophalen en beheren van weergerelateerde locatie-informatie.
 */
interface WeatherRepository {

    /**
     * Haalt de weerinformatie voor de opgegeven locatie op als een [Flow] van [LocatieInfo].
     *
     * @param realLocation De naam van de locatie waarvan de weerinformatie moet worden opgehaald.
     * @return Een [Flow] van [LocatieInfo] die de weerinformatie vertegenwoordigt.
     */
    fun getWeatherLocation(realLocation: String): Flow<LocatieInfo>

    /**
     * Haalt alle weerlocaties op als een [Flow] van een lijst van [LocatieInfo].
     *
     * @return Een [Flow] van een lijst van [LocatieInfo] die de weerlocaties vertegenwoordigt.
     */
    fun getWeatherLocations(): Flow<List<LocatieInfo>>

    /**
     * Voegt de opgegeven weerlocatie toe aan de database.
     *
     * @param locatieInfo De [LocatieInfo] die moet worden toegevoegd.
     */
    suspend fun insertWeatherLocation(locatieInfo: LocatieInfo)

    /**
     * Verwijdert de opgegeven weerlocatie uit de database.
     *
     * @param locatieInfo De [LocatieInfo] die moet worden verwijderd.
     */
    suspend fun deleteWeatherLocation(locatieInfo: LocatieInfo)

    /**
     * Werkt de opgegeven weerlocatie in de database bij.
     *
     * @param locatieInfo De [LocatieInfo] die moet worden bijgewerkt.
     */
    suspend fun updateWeatherLocation(locatieInfo: LocatieInfo)

    /**
     * Vernieuwt de weerinformatie voor de opgegeven locatie en retourneert de bijgewerkte locatienaam.
     *
     * @param loc De naam van de locatie waarvan de weerinformatie moet worden vernieuwd.
     * @return De bijgewerkte locatienaam.
     * @throws Exception Als er een fout optreedt bij het vernieuwen van de weerinformatie.
     */
    suspend fun refresh(loc:String):String
}

/**
 * Implementatie van [WeatherRepository] die gebruikmaakt van een lokale cache voor het opslaan van weerinformatie.
 *
 * @property locatieInfoDao De [LocatieInfoDao] waarmee databasebewerkingen kunnen worden uitgevoerd.
 * @property weatherApiService De [WeatherApiService] waarmee weerinformatie kan worden opgehaald van een externe service.
 */
class CachingWeatherRepository(private val locatieInfoDao:LocatieInfoDao, private val weatherApiService:WeatherApiService
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

    override suspend fun refresh(loc:String):String {
        try {
            val location = weatherApiService.getWeatherLocationAsFlow(loc).asDomainObject().first()
            insertWeatherLocation(location)
            return location.placeName
        } catch (e: Error) {
            throw Exception()
        }
    }

}