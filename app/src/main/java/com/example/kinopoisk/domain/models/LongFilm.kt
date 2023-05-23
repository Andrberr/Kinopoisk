package com.example.kinopoisk.domain.models

data class LongFilm(
    val id: Int, //
    val countries: List<String>, //
    val genres: List<String>, //
    val description: String,
    val enName: String,
    val movieLength: Int, //
    val name: String,  //
    val poster: String, //
    val rating: Float, //
    val shortDescription: String,
    val votesAmount: Int,
    val peopleWait: Int,
    val year: Int, //
    val platforms: List<WatchPlatform>
)