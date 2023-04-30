package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class WatchPlatformsResponse(
    @Json(name = "items") val items: List<WatchPlatformResponse>? = null
)