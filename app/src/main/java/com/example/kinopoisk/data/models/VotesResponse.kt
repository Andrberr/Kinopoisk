package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class VotesResponse(
    @Json(name = "kp") val votesKp: Int? = null,
    @Json(name = "await") val await: Int? = null,
)
