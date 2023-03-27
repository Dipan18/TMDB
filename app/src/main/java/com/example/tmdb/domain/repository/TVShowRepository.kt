package com.example.tmdb.domain.repository

import com.example.tmdb.data.model.tvshow.TVShow

interface TVShowRepository {
    suspend fun getTvShows(): List<TVShow>?
    suspend fun updateTvShows(): List<TVShow>?
}