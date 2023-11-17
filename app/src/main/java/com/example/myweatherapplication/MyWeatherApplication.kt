package com.example.myweatherapplication

import android.app.Application
import com.example.taskapp.data.AppContainer
import com.example.taskapp.data.DefaultAppContainer

class MyWeatherApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}