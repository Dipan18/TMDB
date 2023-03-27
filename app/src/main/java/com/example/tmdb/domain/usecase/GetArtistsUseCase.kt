package com.example.tmdb.domain.usecase

import com.example.tmdb.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() = artistRepository.getArtists()
}