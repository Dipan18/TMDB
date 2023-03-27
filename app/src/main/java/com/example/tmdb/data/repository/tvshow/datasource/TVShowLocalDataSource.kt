package com.example.tmdb.data.repository.tvshow.datasource

import com.example.tmdb.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TVShow>
    suspend fun saveTvShowsInDB(tvShows: List<TVShow>)
    suspend fun deleteAllTvShows()
}