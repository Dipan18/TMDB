package com.example.tmdb.domain.repository

import com.example.tmdb.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}