package com.example.kinopoisk.data

import com.example.kinopoisk.data.mappers.FilmMapper
import com.example.kinopoisk.data.network.FilmInfoService
import com.example.kinopoisk.data.network.NewFilmsService
import com.example.kinopoisk.data.network.RatingFilmsService
import com.example.kinopoisk.domain.Repository
import com.example.kinopoisk.domain.models.LongFilm
import com.example.kinopoisk.domain.models.ShortFilm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val newFilmsService: NewFilmsService,
    private val ratingFilmsService: RatingFilmsService,
    private val filmInfoService: FilmInfoService,
    private val mapper: FilmMapper
) : Repository {
    override suspend fun getNewFilms(): List<ShortFilm> {
        return withContext(Dispatchers.IO) {
            val response = newFilmsService.getMoviesResponse(1, 100, 2023)
            response.data?.map { mapper(it) } ?: emptyList()
        }
    }

    override suspend fun getRatingFilms(rating: String): List<ShortFilm> {
        return withContext(Dispatchers.IO) {
            val response = ratingFilmsService.getMoviesResponse(1, 20, rating)
            response.data?.map { mapper(it) } ?: emptyList()
        }
    }

    override suspend fun getFilmInfo(id: Int): LongFilm {
        return withContext(Dispatchers.IO) {
            mapper.mapToLongFilm(filmInfoService.getFilmInfo(id))
        }
    }
}