package com.example.kinopoisk.ui.home.film

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.kinopoisk.KinopoiskApp
import com.example.kinopoisk.R
import com.example.kinopoisk.databinding.FragmentFilmBinding
import com.example.kinopoisk.di.ViewModelFactory
import com.example.kinopoisk.ui.home.FilmsViewHolder
import com.example.kinopoisk.ui.home.MediaViewModel
import javax.inject.Inject

class FilmFragment : Fragment() {

    private var _binding: FragmentFilmBinding? = null
    private val binding get() = _binding!!

    private val args: FilmFragmentArgs by navArgs()

    @Inject
    lateinit var factory: ViewModelFactory
    private val mediaViewModel: MediaViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as KinopoiskApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mediaViewModel.filmLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                Glide.with(requireContext())
                    .load(it.poster)
                    .into(posterView)

                filmNameView.text = it.name
                ratingView.setBackgroundResource(
                    if (it.rating >= GOOD_RATING) R.drawable.good_rating_background
                    else if (it.rating >= NORM_RATING) R.drawable.norm_rating_background
                    else R.drawable.bad_rating_background
                )
                ratingView.text = it.rating.toString()

                var genres = ""
                for (i in 0 until it.genres.size) {
                    genres += it.genres[i] + "\n"
                }
                yearGenresView.text = it.year.toString() + "\n" + genres

                var countries = ""
                for (i in 0..it.countries.size){
                    countries+=it.countries[i] + "\n"
                }
                countriesLengthView
            }
        }
        mediaViewModel.getFilmInfo(args.id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val GOOD_RATING = 7
        private const val NORM_RATING = 5
    }
}