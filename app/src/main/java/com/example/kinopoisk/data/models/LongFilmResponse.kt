package com.example.kinopoisk.data.models

import com.squareup.moshi.Json

data class LongFilmResponse(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "countries") val countries: List<NameResponse>? = null,
    @Json(name = "genres") val genres: List<NameResponse>? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "enName") val enName: String? = null,
    @Json(name = "movieLength") val movieLength: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "poster") val poster: UrlResponse? = null,
    @Json(name = "rating") val rating: RatingResponse? = null,
    @Json(name = "shortDescription") val shortDescription: String? = null,
    @Json(name = "votes") val votes: VotesResponse? = null,
    @Json(name = "year") val year: Int? = null,
    @Json(name = "watchability") val watchability: WatchPlatformsResponse? = null
)
