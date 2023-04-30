package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class NameResponse(
    @Json(name = "name") val value: String? = null
)
