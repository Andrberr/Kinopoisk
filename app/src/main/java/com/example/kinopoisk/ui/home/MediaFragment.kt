package com.example.kinopoisk.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kinopoisk.KinopoiskApp
import com.example.kinopoisk.databinding.FragmentHomeBinding
import com.example.kinopoisk.di.ViewModelFactory
import javax.inject.Inject

class MediaFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val mediaViewModel: MediaViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as KinopoiskApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val newFilmsAdapter = FilmsAdapter()
        binding.newFilmsRecycler.apply {
            adapter = newFilmsAdapter
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        mediaViewModel.newFilmsLiveData.observe(viewLifecycleOwner) {
            newFilmsAdapter.setFilms(it)
        }
        mediaViewModel.getNewFilms()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}