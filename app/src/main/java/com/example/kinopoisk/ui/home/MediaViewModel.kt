package com.example.kinopoisk.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.domain.Repository
import com.example.kinopoisk.domain.models.ShortFilm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MediaViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _newFilmsLiveData = MutableLiveData<List<ShortFilm>>()
    val newFilmsLiveData: LiveData<List<ShortFilm>> get() = _newFilmsLiveData

    private val _popularFilmsLiveData = MutableLiveData<List<ShortFilm>>()
    val popularFilmsLiveData: LiveData<List<ShortFilm>> get() = _popularFilmsLiveData

    fun getNewFilms() {
        viewModelScope.launch {
            _newFilmsLiveData.value = repository.getNewFilms()
        }
    }

    fun getPopularFilms(rating: String) {
        viewModelScope.launch {
            _popularFilmsLiveData.value = repository.getPopularFilms(rating)
        }
    }

    companion object {
        private const val FILMS_AMOUNT = 5
    }
}