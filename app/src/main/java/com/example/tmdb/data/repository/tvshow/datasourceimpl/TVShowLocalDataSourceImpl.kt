package com.example.tmdb.data.repository.tvshow.datasourceimpl

import com.example.tmdb.data.db.TVShowDao
import com.example.tmdb.data.model.tvshow.TVShow
import com.example.tmdb.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TVShow> = tvShowDao.getAllTvShows()

    override suspend fun saveTvShowsInDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun deleteAllTvShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}