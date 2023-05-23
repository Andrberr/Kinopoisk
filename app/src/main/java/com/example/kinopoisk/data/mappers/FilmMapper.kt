package com.example.kinopoisk.data.mappers

import com.example.kinopoisk.data.models.*
import com.example.kinopoisk.domain.models.LongFilm
import com.example.kinopoisk.domain.models.ShortFilm
import com.example.kinopoisk.domain.models.WatchPlatform
import javax.inject.Inject

class FilmMapper @Inject constructor() {
    operator fun invoke(response: ShortFilmResponse): ShortFilm = with(response) {
        ShortFilm(
            id = id ?: 0,
            genre = getGenre(genres),
            name = name ?: "",
            poster = poster?.url ?: "",
            rating = rating?.kp?.modify() ?: 0f,
        )
    }

    fun mapToLongFilm(response: LongResponse): LongFilm {
        val list = response.data
            ?: return LongFilm(
                0, emptyList(), emptyList(), "", "", 0, "", "", 0f,
                "", 0, 0, 0, emptyList()
            )
        return with(list[0]) {
            LongFilm(
                id = id ?: 0,
                countries = countries?.map { it.value ?: "" } ?: emptyList(),
                genres = genres?.map { it.value ?: "" } ?: emptyList(),
                description = description ?: "",
                enName = enName ?: "",
                movieLength = movieLength ?: 0,
                name = name ?: "",
                poster = poster?.url ?: "",
                rating = rating?.kp?.modify() ?: 0f,
                shortDescription = shortDescription ?: "",
                votesAmount = votes?.votesKp ?: 0,
                peopleWait = votes?.await ?: 0,
                year = year ?: 2000,
                platforms = watchability?.items?.map { mapWatchPlatformItem(it) } ?: emptyList()
            )
        }
    }

    private fun mapWatchPlatformItem(item: WatchPlatformResponse): WatchPlatform = with(item) {
        WatchPlatform(
            name = name ?: "",
            logo = logo?.url ?: "",
            url = url ?: ""
        )
    }

    private fun getGenre(genres: List<NameResponse>?): String {
        val list = genres?.map { it.value ?: "" } ?: emptyList()
        return if (list.isNotEmpty()) list[0]
        else ""
    }

    private fun Float.modify(): Float {
        val str = this.toString().split(".")
        return (str[0] + '.' + str[1][0]).toFloat()
    }
}