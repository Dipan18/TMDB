package com.example.tmdb.ui.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.databinding.ListItemArtistBinding

class ArtistAdapter() : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {
    private val artist = ArrayList<Artist>()

    fun setArtists(artists: List<Artist>) {
        this.artist.clear()
        this.artist.addAll(artists)
    }

    inner class ArtistViewHolder(private val binding: ListItemArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Artist) {
            binding.apply {
                tvTitle.text = artist.name

                val posterUrl = "https://image.tmdb.org/t/p/w500${artist.profilePath}"
                Glide.with(binding.ivPoster.context).load(posterUrl).into(binding.ivPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder =
        ArtistViewHolder(
            ListItemArtistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = artist.size

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artist[position])
    }
}