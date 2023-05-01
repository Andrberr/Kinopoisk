package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class UrlResponse(
    @Json(name = "previewUrl") val url: String? = null
)
