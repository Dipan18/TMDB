package com.example.tmdb.data.repository.tvshow

import android.util.Log
import com.example.tmdb.data.model.tvshow.TVShow
import com.example.tmdb.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.example.tmdb.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.example.tmdb.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.example.tmdb.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowRepository {
    override suspend fun getTvShows(): List<TVShow> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TVShow> {
        val tvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.deleteAllTvShows()
        tvShowLocalDataSource.saveTvShowsInDB(tvShows)
        tvShowCacheDataSource.saveTvShowsInCache(tvShows)
        return tvShows
    }

    private suspend fun getTvShowsFromAPI(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTvShowsFromAPI()
            val body = response.body()

            if (body != null) {
                tvShows = body.TVShows
            }
        } catch (exception: Exception) {
            Log.i("error", exception.message.toString())
        }

        return tvShows
    }

    private suspend fun getTvShowsFromDB(): List<TVShow> {
        lateinit var tvShows: List<TVShow>
        try {
            tvShows = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("error", exception.message.toString())
        }

        if (tvShows.isEmpty()) {
            tvShows = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsInDB(tvShows)
        }

        return tvShows
    }

    private suspend fun getTvShowsFromCache(): List<TVShow> {
        var tvShow: List<TVShow> = tvShowCacheDataSource.getTvShowsFromCache()

        if (tvShow.isEmpty()) {
            tvShow = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsInCache(tvShow)
        }

        return tvShow
    }
}