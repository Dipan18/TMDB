package com.example.tmdb.data.repository.tvshow.datasource

import com.example.tmdb.data.model.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TVShow>
    suspend fun saveTvShowsInCache(tvShows: List<TVShow>)
}