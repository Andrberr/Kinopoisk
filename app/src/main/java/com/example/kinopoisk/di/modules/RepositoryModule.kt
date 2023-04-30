package com.example.kinopoisk.di.modules

import com.example.kinopoisk.data.RepositoryImpl
import com.example.kinopoisk.domain.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(impl: RepositoryImpl): Repository
}