package com.example.myweatherapplication

import android.app.Application
import com.example.myweatherapplication.data.AppContainer
import com.example.myweatherapplication.data.DefaultAppContainer

/**
 * Aangepaste [Application]-klasse voor de weer-applicatie.
 */
class MyWeatherApplication : Application() {
    /**
     * De [AppContainer] dat de afhankelijkheden van de applicatie beheert.
     */
    lateinit var container: AppContainer

    /**
     * Wordt opgeroepen wanneer de applicatie wordt aangemaakt. Initialiseert de [AppContainer].
     */
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(context = applicationContext)
    }
}