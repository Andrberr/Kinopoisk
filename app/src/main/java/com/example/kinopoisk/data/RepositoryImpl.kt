package com.example.kinopoisk.data

import com.example.kinopoisk.data.mappers.FilmMapper
import com.example.kinopoisk.data.network.MovieService
import com.example.kinopoisk.domain.Repository
import com.example.kinopoisk.domain.models.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val mapper: FilmMapper
) : Repository {
    override suspend fun getAllFilms(): List<Film> {
        return withContext(Dispatchers.IO) {
            val response = movieService.getMoviesResponse(1, 100, 2023)
            response.data?.map { mapper(it) } ?: emptyList()
        }
    }
}