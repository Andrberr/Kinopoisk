package com.example.kinopoisk.data.mappers

import com.example.kinopoisk.data.models.FilmResponse
import com.example.kinopoisk.data.models.NameResponse
import com.example.kinopoisk.data.models.WatchPlatformResponse
import com.example.kinopoisk.data.models.WatchPlatformsResponse
import com.example.kinopoisk.domain.models.Film
import com.example.kinopoisk.domain.models.WatchPlatform
import javax.inject.Inject

class FilmMapper @Inject constructor() {
    operator fun invoke(response: FilmResponse): Film = with(response) {
        Film(
            id = id ?: 0,
            countries = countries?.map { it.value ?: "" } ?: emptyList(),
            genres = genres?.map { it.value ?: "" } ?: emptyList(),
            description = description ?: "",
            enName = enName ?: "",
            movieLength = movieLength ?: 0,
            name = name ?: "",
            poster = poster?.url ?: "",
            rating = rating?.kp ?: 0f,
            shortDescription = shortDescription ?: "",
            votesAmount = votes?.votesKp ?: 0,
            peopleWait = votes?.await ?: 0,
            year = year ?: 2000,
            platforms = watchability?.items?.map { mapWatchPlatformItem(it) } ?: emptyList()
        )
    }

    fun mapWatchPlatformItem(item: WatchPlatformResponse): WatchPlatform = with(item) {
        WatchPlatform(
            name = name ?: "",
            logo = logo?.url ?: "",
            url = url ?: ""
        )
    }
}