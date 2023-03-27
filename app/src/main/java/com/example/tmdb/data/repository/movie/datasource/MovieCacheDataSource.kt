package com.example.tmdb.data.repository.movie.datasource

import com.example.tmdb.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}