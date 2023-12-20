package com.example.myweatherapplication
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myweatherapplication.data.database.LocatieInfoDao
import com.example.myweatherapplication.data.database.LocatieInfoDb
import com.example.myweatherapplication.data.database.asDbWeatherLocation
import com.example.myweatherapplication.data.database.asDomainLocatieInfo
import com.example.myweatherapplication.ui.model.LocatieInfo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class LocatieInfoDaoTest {
    private lateinit var locatieInfoDao: LocatieInfoDao
    private lateinit var locatieInfoDb: LocatieInfoDb

    private var locatie1 = LocatieInfo("first", 0.0,0.0,"",0.0,0,0.0,0,0.0,0.0)
    private var locatie2 = LocatieInfo("second", 0.0,0.0,"",0.0,0,0.0,0,0.0,0.0)

    // utility functions
    private suspend fun addOneLocatieInfoToDb() {
        locatieInfoDao.insert(locatie1.asDbWeatherLocation())
    }

    private suspend fun addTwoTasksToDb() {
        locatieInfoDao.insert(locatie1.asDbWeatherLocation())
        locatieInfoDao.insert(locatie2.asDbWeatherLocation())
    }

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        locatieInfoDb = Room.inMemoryDatabaseBuilder(context, LocatieInfoDb::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        locatieInfoDao = locatieInfoDb.locatieInfoDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        locatieInfoDb.close()
    }

    @Test
    @Throws(Exception::class)
    fun daoInert_insertTaskIntoDB() = runBlocking {
        addOneLocatieInfoToDb()
        val allItems = locatieInfoDao.getAllItems().first()
        assertEquals(allItems[0].asDomainLocatieInfo(), locatie1)
    }

    @Test
    @Throws(Exception::class)
    fun daoGetAllTasks_returnsAllTasksFromDB() = runBlocking {
        addTwoTasksToDb()
        val allItems = locatieInfoDao.getAllItems().first()
        assertEquals(allItems[0].asDomainLocatieInfo(), locatie1)
        assertEquals(allItems[1].asDomainLocatieInfo(), locatie2)
    }
}