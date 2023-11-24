package com.example.myweatherapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [dbLocatieInfo::class], version = 1, exportSchema = false)
abstract class LocatieInfoDb : RoomDatabase() {

    abstract fun locatieInfoDao(): LocatieInfoDao

    companion object {
        @Volatile
        private var Instance: LocatieInfoDb? = null

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