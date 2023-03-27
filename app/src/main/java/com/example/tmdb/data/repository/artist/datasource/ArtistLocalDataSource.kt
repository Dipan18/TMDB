package com.example.tmdb.data.repository.artist.datasource

import com.example.tmdb.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsInDB(artists: List<Artist>)
    suspend fun deleteAllArtistsFromDB()
}