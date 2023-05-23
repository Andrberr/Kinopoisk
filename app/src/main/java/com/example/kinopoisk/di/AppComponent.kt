package com.example.kinopoisk.di

import android.content.Context
import com.example.kinopoisk.di.modules.NetworkModule
import com.example.kinopoisk.di.modules.RepositoryModule
import com.example.kinopoisk.di.modules.ViewModelModule
import com.example.kinopoisk.ui.MainActivity
import com.example.kinopoisk.ui.home.MediaFragment
import com.example.kinopoisk.ui.home.film.FilmFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: MediaFragment)
    fun inject(fragment: FilmFragment)
}