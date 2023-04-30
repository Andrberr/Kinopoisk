package com.example.kinopoisk.ui.home

import androidx.lifecycle.ViewModel
import com.example.kinopoisk.domain.Repository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

}