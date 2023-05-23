package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class LongResponse(
    @Json(name = "docs") val data: List<LongFilmResponse>? = null
)