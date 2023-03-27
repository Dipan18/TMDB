package com.example.tmdb.data.repository.movie.datasource

import com.example.tmdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMoviesFromAPI(): Response<MovieList>
}