package com.example.kinopoisk.domain

import com.example.kinopoisk.domain.models.Film

interface Repository {
    suspend fun getAllFilms(): List<Film>
}