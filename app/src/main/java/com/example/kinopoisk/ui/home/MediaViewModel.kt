package com.example.kinopoisk.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.domain.Repository
import com.example.kinopoisk.domain.models.ShortFilm
import kotlinx.coroutines.launch
import javax.inject.Inject

class MediaViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _newFilmsLiveData = MutableLiveData<List<ShortFilm>>()
    val newFilmsLiveData: LiveData<List<ShortFilm>> get() = _newFilmsLiveData

    fun getNewFilms() {
        viewModelScope.launch {
            _newFilmsLiveData.value = repository.getNewFilms()
        }
    }

}