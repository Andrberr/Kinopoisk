package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class WatchPlatformResponse(
    @Json(name = "name") val name: String? = null,
    @Json(name = "logo") val logo: UrlResponse? = null,
    @Json(name = "url") val url: String? = null,
)