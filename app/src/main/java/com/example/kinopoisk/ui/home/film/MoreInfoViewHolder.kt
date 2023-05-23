package com.example.kinopoisk.ui.home.film

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.databinding.PlatformLayoutBinding
import com.example.kinopoisk.domain.models.WatchPlatform

class MoreInfoViewHolder(
    private val binding: PlatformLayoutBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(watchPlatform: WatchPlatform) {
        binding.platformNameView.text = watchPlatform.name
        binding.forwardButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(watchPlatform.url))
            startActivity(itemView.context, intent, null)
        }
    }
}