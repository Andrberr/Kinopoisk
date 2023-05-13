package com.example.kinopoisk.domain

import com.example.kinopoisk.domain.models.ShortFilm

interface Repository {
    suspend fun getNewFilms(): List<ShortFilm>
    suspend fun getPopularFilms(rating: String): List<ShortFilm>
}