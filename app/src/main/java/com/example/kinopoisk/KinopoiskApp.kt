package com.example.kinopoisk

import android.app.Application
import com.example.kinopoisk.di.AppComponent
import com.example.kinopoisk.di.DaggerAppComponent

class KinopoiskApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}