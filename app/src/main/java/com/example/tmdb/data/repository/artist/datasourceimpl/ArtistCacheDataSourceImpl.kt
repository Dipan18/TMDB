package com.example.tmdb.data.repository.artist.datasourceimpl

import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artists = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> = artists

    override suspend fun saveArtistsInCache(artists: List<Artist>) {
        this.artists.clear()
        this.artists = ArrayList(artists)
    }
}