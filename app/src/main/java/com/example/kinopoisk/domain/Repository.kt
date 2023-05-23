package com.example.kinopoisk.domain

import com.example.kinopoisk.domain.models.LongFilm
import com.example.kinopoisk.domain.models.ShortFilm

interface Repository {
    suspend fun getNewFilms(): List<ShortFilm>
    suspend fun getRatingFilms(rating: String): List<ShortFilm>
    suspend fun getFilmInfo(id: Int): LongFilm
}