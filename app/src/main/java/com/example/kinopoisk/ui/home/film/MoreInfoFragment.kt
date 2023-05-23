package com.example.kinopoisk.ui.home.film

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kinopoisk.KinopoiskApp
import com.example.kinopoisk.databinding.FragmentMoreInfoBinding
import com.example.kinopoisk.di.ViewModelFactory
import com.example.kinopoisk.ui.home.MediaViewModel
import javax.inject.Inject

class MoreInfoFragment : Fragment() {

    private var _binding: FragmentMoreInfoBinding? = null
    private val binding get() = _binding!!

    private val args: MoreInfoFragmentArgs by navArgs()

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: MediaViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as KinopoiskApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val action = MoreInfoFragmentDirections.actionMoreInfoFragmentToFilmFragment(args.id)
                    findNavController().navigate(action)
                }
            })

        _binding = FragmentMoreInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val moreInfoAdapter = MoreInfoAdapter()
        binding.platformsRecycler.apply {
            adapter = moreInfoAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.filmLiveData.observe(viewLifecycleOwner) {
            binding.descriptionView.text = it.description
            moreInfoAdapter.setPlatforms(it.platforms)
        }
        viewModel.getFilmInfo(args.id)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}