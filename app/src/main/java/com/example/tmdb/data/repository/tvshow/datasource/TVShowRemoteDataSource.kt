package com.example.tmdb.data.repository.tvshow.datasource

import com.example.tmdb.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTvShowsFromAPI(): Response<TVShowList>
}