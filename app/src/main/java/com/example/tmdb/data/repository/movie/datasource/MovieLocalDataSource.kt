package com.example.tmdb.data.repository.movie.datasource

import com.example.tmdb.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun deleteAllMovies()
}