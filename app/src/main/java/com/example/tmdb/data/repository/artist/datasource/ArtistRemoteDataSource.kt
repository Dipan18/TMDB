package com.example.tmdb.data.repository.artist.datasource

import com.example.tmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtistsFromAPI(): Response<ArtistList>
}