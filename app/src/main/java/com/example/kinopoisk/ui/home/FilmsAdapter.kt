package com.example.kinopoisk.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.databinding.FilmLayoutBinding
import com.example.kinopoisk.domain.models.ShortFilm

class FilmsAdapter : RecyclerView.Adapter<FilmsViewHolder>() {

    private val filmsList = mutableListOf<ShortFilm>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val binding = FilmLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmsViewHolder(binding)
    }

    override fun getItemCount(): Int = filmsList.size

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.onBind(filmsList[position])
    }

    fun setFilms(shortFilms: List<ShortFilm>) {
        filmsList.clear()
        filmsList.addAll(shortFilms)
        notifyDataSetChanged()
    }
}