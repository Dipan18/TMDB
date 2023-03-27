package com.example.tmdb.domain.usecase

import com.example.tmdb.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() = movieRepository.getMovies()
}