package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class AllDataResponse(
    @Json(name = "docs") val data: List<FilmResponse>? = null
)
