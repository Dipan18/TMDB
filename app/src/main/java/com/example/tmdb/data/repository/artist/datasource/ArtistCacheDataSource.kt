package com.example.tmdb.data.repository.artist.datasource

import com.example.tmdb.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsInCache(artists: List<Artist>)
}