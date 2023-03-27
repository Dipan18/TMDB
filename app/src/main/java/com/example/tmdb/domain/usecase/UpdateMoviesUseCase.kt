package com.example.tmdb.domain.usecase

import com.example.tmdb.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() = movieRepository.updateMovies()
}