package com.example.kinopoisk.domain.models

data class ShortFilm(
    val id: Int,
    val genre: String,
    val name: String,
    val poster: String,
    val rating: Float,
)