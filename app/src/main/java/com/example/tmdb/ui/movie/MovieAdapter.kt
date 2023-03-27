package com.example.tmdb.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.databinding.ListItemMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val movies = ArrayList<Movie>()

    fun setMovies(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            ListItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class MovieViewHolder(private val binding: ListItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.tvTitle.text = movie.title
            binding.tvOverview.text = movie.overview

            val posterUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
            Glide.with(binding.ivPoster.context).load(posterUrl).into(binding.ivPoster)
        }
    }
}