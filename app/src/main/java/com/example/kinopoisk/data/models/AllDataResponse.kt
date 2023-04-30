package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class AllDataResponse(
    @Json(name = "data") val data: List<FilmResponse>? = null
)
