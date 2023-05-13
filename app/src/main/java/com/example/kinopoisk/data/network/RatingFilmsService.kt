package com.example.kinopoisk.data.network

import com.example.kinopoisk.data.models.AllDataResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RatingFilmsService {
    @Headers("X-API-KEY: 2Q9PWKM-TRNMNMB-PH0Z4JW-3Q3FJ7D")
    @GET("v1.3/movie")
    suspend fun getMoviesResponse(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("rating.kp") ratingKp: String,
        @Query("selectFields") id: String = "id",
        @Query("selectFields") genres: String = "genres",
        @Query("selectFields") name: String = "name",
        @Query("selectFields") poster: String = "poster",
        @Query("selectFields") rating: String = "rating",
    ): AllDataResponse
}