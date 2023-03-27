package com.example.tmdb.data.repository.artist.datasourceimpl

import com.example.tmdb.data.db.ArtistDao
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getAllArtists()

    override suspend fun saveArtistsInDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun deleteAllArtistsFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}