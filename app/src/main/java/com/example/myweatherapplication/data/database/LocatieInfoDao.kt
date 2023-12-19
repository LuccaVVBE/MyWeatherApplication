package com.example.myweatherapplication.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LocatieInfoDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(locatieInfo: dbLocatieInfo)

    @Update
    suspend fun update(locatieInfo: dbLocatieInfo)

    @Delete
    suspend fun delete(locatieInfo: dbLocatieInfo)

    @Query("SELECT * from locatie_info WHERE placeName = :realLocation")
    fun getItem(realLocation: String): Flow<dbLocatieInfo>

    @Query("SELECT * from locatie_info ORDER BY placeName ASC")
    fun getAllItems(): Flow<List<dbLocatieInfo>>
}