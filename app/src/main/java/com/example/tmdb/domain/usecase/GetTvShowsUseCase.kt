package com.example.tmdb.domain.usecase

import com.example.tmdb.domain.repository.TVShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute() = tvShowRepository.getTvShows()
}