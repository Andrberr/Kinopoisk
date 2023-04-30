package com.example.kinopoisk.data.network

import com.example.kinopoisk.data.models.AllDataResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieService {
    @Headers("token: 2Q9PWKM-TRNMNMB-PH0Z4JW-3Q3FJ7D")
    @GET("v1.3/movie")
    suspend fun getMoviesResponse(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("year") year: Int
    ): AllDataResponse
}