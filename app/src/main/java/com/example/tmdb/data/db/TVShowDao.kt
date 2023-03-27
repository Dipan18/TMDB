package com.example.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb.data.model.tvshow.TVShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TVShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getAllTvShows(): List<TVShow>
}