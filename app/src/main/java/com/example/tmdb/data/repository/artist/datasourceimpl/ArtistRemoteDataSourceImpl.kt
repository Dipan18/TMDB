package com.example.tmdb.data.repository.artist.datasourceimpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.artist.ArtistList
import com.example.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService) : ArtistRemoteDataSource {
    override suspend fun getArtistsFromAPI(): Response<ArtistList> = tmdbService.getPopularArtists()
}