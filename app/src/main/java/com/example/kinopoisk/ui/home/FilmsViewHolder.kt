package com.example.kinopoisk.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.kinopoisk.R
import com.example.kinopoisk.databinding.FilmLayoutBinding
import com.example.kinopoisk.domain.models.ShortFilm

class FilmsViewHolder(
    private val binding: FilmLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(shortFilm: ShortFilm) {
        with(binding) {

            Glide.with(itemView.context)
                .load(shortFilm.poster)
                .override(Target.SIZE_ORIGINAL)
                .into(posterView)

            filmNameView.text = shortFilm.name
            genreView.text = shortFilm.genre
            if (shortFilm.rating != 0f) {
                ratingView.setBackgroundResource(
                    if (shortFilm.rating >= GOOD_RATING) R.drawable.good_rating_background
                    else if (shortFilm.rating >= NORM_RATING) R.drawable.norm_rating_background
                    else R.drawable.bad_rating_background
                )
                ratingView.text = shortFilm.rating.toString()
            }
        }
    }

    companion object {
        private const val GOOD_RATING = 7
        private const val NORM_RATING = 5
    }
}