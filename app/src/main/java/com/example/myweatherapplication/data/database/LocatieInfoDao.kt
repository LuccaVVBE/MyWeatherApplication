package com.example.myweatherapplication.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) voor het uitvoeren van databasebewerkingen met betrekking tot locatie-informatie.
 */
@Dao
interface LocatieInfoDao{
    /**
     * Voegt locatie-informatie toe aan de database of vervangt deze als deze al bestaat.
     *
     * @param locatieInfo Het [dbLocatieInfo]-object dat moet worden toegevoegd of vervangen.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(locatieInfo: dbLocatieInfo)

    /**
     * Werkt de bestaande locatie-informatie in de database bij.
     *
     * @param locatieInfo Het bij te werken [dbLocatieInfo]-object.
     */
    @Update
    suspend fun update(locatieInfo: dbLocatieInfo)

    /**
     * Verwijdert de opgegeven locatie-informatie uit de database.
     *
     * @param locatieInfo Het te verwijderen [dbLocatieInfo]-object.
     */
    @Delete
    suspend fun delete(locatieInfo: dbLocatieInfo)

    /**
     * Haalt locatie-informatie op uit de database op basis van de opgegeven locatienaam.
     *
     * @param realLocation De naam van de locatie waarvan de informatie moet worden opgehaald.
     * @return Een [Flow] van [dbLocatieInfo] die overeenkomt met de opgegeven locatienaam.
     */
    @Query("SELECT * from locatie_info WHERE placeName = :realLocation")
    fun getItem(realLocation: String): Flow<dbLocatieInfo>

    /**
     * Haalt alle locatie-informatie op uit de database, gesorteerd op locatienaam in oplopende volgorde.
     *
     * @return Een [Flow] van een lijst van alle [dbLocatieInfo]-objecten in de database.
     */
    @Query("SELECT * from locatie_info ORDER BY placeName ASC")
    fun getAllItems(): Flow<List<dbLocatieInfo>>
}