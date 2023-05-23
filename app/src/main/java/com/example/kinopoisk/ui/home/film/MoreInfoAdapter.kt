package com.example.kinopoisk.ui.home.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.databinding.PlatformLayoutBinding
import com.example.kinopoisk.domain.models.WatchPlatform

class MoreInfoAdapter : RecyclerView.Adapter<MoreInfoViewHolder>() {

    private val platforms = mutableListOf<WatchPlatform>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreInfoViewHolder {
        val binding =
            PlatformLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoreInfoViewHolder(binding)
    }

    override fun getItemCount(): Int = platforms.size

    override fun onBindViewHolder(holder: MoreInfoViewHolder, position: Int) {
        holder.onBind(platforms[position])
    }

    fun setPlatforms(platformsList: List<WatchPlatform>) {
        platforms.clear()
        platforms.addAll(platformsList)
        notifyDataSetChanged()
    }
}