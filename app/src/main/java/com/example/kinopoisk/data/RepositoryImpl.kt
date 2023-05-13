package com.example.kinopoisk.data

import com.example.kinopoisk.data.mappers.FilmMapper
import com.example.kinopoisk.data.network.NewFilmsService
import com.example.kinopoisk.data.network.RatingFilmsService
import com.example.kinopoisk.domain.Repository
import com.example.kinopoisk.domain.models.ShortFilm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val newFilmsService: NewFilmsService,
    private val ratingFilmsService: RatingFilmsService,
    private val mapper: FilmMapper
) : Repository {
    override suspend fun getNewFilms(): List<ShortFilm> {
        return withContext(Dispatchers.IO) {
            val response = newFilmsService.getMoviesResponse(1, 100, 2023)
            response.data?.map { mapper(it) } ?: emptyList()
        }
    }

    override suspend fun getPopularFilms(rating: String): List<ShortFilm> {
        return withContext(Dispatchers.IO) {
            val response = ratingFilmsService.getMoviesResponse(1,20, rating)
            response.data?.map { mapper(it) } ?: emptyList()
        }
    }
}