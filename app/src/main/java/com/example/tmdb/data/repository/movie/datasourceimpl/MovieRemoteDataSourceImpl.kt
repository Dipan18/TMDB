package com.example.tmdb.data.repository.movie.datasourceimpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.movie.MovieList
import com.example.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService) : MovieRemoteDataSource {
    override suspend fun getMoviesFromAPI(): Response<MovieList> = tmdbService.getPopularMovies()
}