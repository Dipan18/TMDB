package com.example.tmdb.domain.usecase

import com.example.tmdb.domain.repository.TVShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute() = tvShowRepository.updateTvShows()
}