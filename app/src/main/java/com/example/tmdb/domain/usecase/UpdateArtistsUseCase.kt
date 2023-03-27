package com.example.tmdb.domain.usecase

import com.example.tmdb.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() = artistRepository.updateArtists()
}