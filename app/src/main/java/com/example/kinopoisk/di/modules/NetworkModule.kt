package com.example.kinopoisk.di.modules

import com.example.kinopoisk.data.network.FilmInfoService
import com.example.kinopoisk.data.network.NewFilmsService
import com.example.kinopoisk.data.network.RatingFilmsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.kinopoisk.dev/v1.3/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
    }


    @Provides
    @Singleton
    fun getNewFilmsService(retrofit: Retrofit): NewFilmsService =
        retrofit.create(NewFilmsService::class.java)

    @Provides
    @Singleton
    fun getPopularFilmsService(retrofit: Retrofit): RatingFilmsService =
        retrofit.create(RatingFilmsService::class.java)

    @Provides
    @Singleton
    fun getFilmInfoService(retrofit: Retrofit): FilmInfoService =
        retrofit.create(FilmInfoService::class.java)

    @Provides
    @Singleton
    fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }
}