package com.example.tmdb.data.repository.tvshow.datasourceimpl

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.model.tvshow.TVShowList
import com.example.tmdb.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(private val tmdbService: TMDBService) : TVShowRemoteDataSource {
    override suspend fun getTvShowsFromAPI(): Response<TVShowList> = tmdbService.getPopularTVShows()
}