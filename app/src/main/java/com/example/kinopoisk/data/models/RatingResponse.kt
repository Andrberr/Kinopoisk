package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class RatingResponse(
    @Json(name="kp") val kp: Float? = null
)
