package com.example.tmdb.ui.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.data.model.tvshow.TVShow
import com.example.tmdb.databinding.ListItemTvShowBinding

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {
    private val tvShows = ArrayList<TVShow>()

    fun setTvShows(tvShows: List<TVShow>) {
        this.tvShows.clear()
        this.tvShows.addAll(tvShows)
    }

    inner class TVShowViewHolder(private val binding: ListItemTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShow) {
            binding.apply {
                tvTitle.text = tvShow.name
                tvOverview.text = tvShow.overview

                val posterUrl = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}"
                Glide.with(ivPoster.context).load(posterUrl).into(binding.ivPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TVShowViewHolder(
            ListItemTvShowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = tvShows.size

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }
}