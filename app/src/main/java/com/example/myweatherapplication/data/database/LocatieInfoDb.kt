package com.example.myweatherapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Databaseklasse voor het beheren van de lokale Room-database met betrekking tot locatie-informatie.
 *
 * @property locatieInfoDao De [LocatieInfoDao] waarmee databasebewerkingen kunnen worden uitgevoerd.
 */
@Database(entities = [dbLocatieInfo::class], version = 1, exportSchema = false)
abstract class LocatieInfoDb : RoomDatabase() {

    abstract fun locatieInfoDao(): LocatieInfoDao

    companion object {
        @Volatile
        private var Instance: LocatieInfoDb? = null

        /**
         * Geeft een instantie van de database terug of maakt een nieuwe database-instantie als deze niet bestaat.
         *
         * @param context De [Context] van de toepassing.
         * @return Een [LocatieInfoDb]-instantie.
         */
        fun getDatabase(context: Context): LocatieInfoDb {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, LocatieInfoDb::class.java, "weather_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}