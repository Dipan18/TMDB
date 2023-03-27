package com.example.tmdb.data.repository.movie.datasourceimpl

import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movies = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> = movies

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        this.movies.clear()
        this.movies = ArrayList(movies)
    }
}