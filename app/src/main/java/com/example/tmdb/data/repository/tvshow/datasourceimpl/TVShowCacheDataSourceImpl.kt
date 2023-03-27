package com.example.tmdb.data.repository.tvshow.datasourceimpl

import com.example.tmdb.data.model.tvshow.TVShow
import com.example.tmdb.data.repository.tvshow.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl : TVShowCacheDataSource {
    private var tvShows = ArrayList<TVShow>()

    override suspend fun getTvShowsFromCache(): List<TVShow> = tvShows

    override suspend fun saveTvShowsInCache(tvShows: List<TVShow>) {
        this.tvShows.clear()
        this.tvShows = ArrayList(tvShows)
    }
}