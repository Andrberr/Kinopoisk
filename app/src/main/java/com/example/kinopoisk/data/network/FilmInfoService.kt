package com.example.kinopoisk.data.network

import com.example.kinopoisk.data.models.*
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FilmInfoService {

    @Headers("X-API-KEY: 2Q9PWKM-TRNMNMB-PH0Z4JW-3Q3FJ7D")
    @GET("movie")
    suspend fun getFilmInfo(
        @Query("id") id: Int,
//        @Query("selectFields") countries: String = "countries",
//        @Query("selectFields") genres: String = "genres",
//        @Query("selectFields") description: String = "description",
//        @Query("selectFields") enName: String = "enName",
//        @Query("selectFields") movieLength: String = "movieLength",
//        @Query("selectFields") name: String = "name",
//        @Query("selectFields") poster: String = "poster",
//        @Query("selectFields") rating: String = "rating",
//        @Query("selectFields") shortDescription: String = "shortDescription",
//        @Query("selectFields") votes: String = "votes",
//        @Query("selectFields") year: String = "year",
//        @Query("selectFields") watchability: String = "watchability",
    ): LongResponse
}