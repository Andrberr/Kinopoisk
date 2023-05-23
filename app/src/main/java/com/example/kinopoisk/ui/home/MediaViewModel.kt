package com.example.kinopoisk.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.domain.Repository
import com.example.kinopoisk.domain.models.LongFilm
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

    private val _ratingFilmsLiveData = MutableLiveData<List<ShortFilm>>()
    val ratingFilmsLiveData: LiveData<List<ShortFilm>> get() = _ratingFilmsLiveData

    private val _filmLiveData = MutableLiveData<LongFilm>()
    val filmLiveData: LiveData<LongFilm> get() = _filmLiveData

    fun getNewFilms() {
        viewModelScope.launch {
            _newFilmsLiveData.value = repository.getNewFilms()
        }
    }

    fun getRatingFilms(rating: String) {
        viewModelScope.launch {
            _ratingFilmsLiveData.value = repository.getRatingFilms(rating)
        }
    }

    fun getFilmInfo(id: Int) {
        viewModelScope.launch {
            _filmLiveData.value = repository.getFilmInfo(id)
        }
    }
}