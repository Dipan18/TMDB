package com.example.tmdb.data.repository.artist

import android.util.Log
import com.example.tmdb.data.model.artist.Artist
import com.example.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdb.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist> = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist> {
        val newArtistsList = getArtistsFromAPI()
        artistLocalDataSource.deleteAllArtistsFromDB()
        artistLocalDataSource.saveArtistsInDB(newArtistsList)
        artistCacheDataSource.saveArtistsInCache(newArtistsList)
        return newArtistsList
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artists: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtistsFromAPI()
            val body = response.body()
            if (body != null) {
                artists = body.artists
            }
        } catch (exception: Exception) {
            Log.i("error", exception.message.toString())
        }

        return artists
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artists: List<Artist>
        try {
            artists = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("error", exception.message.toString())
        }

        if (artists.isEmpty()) {
            artists = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsInDB(artists)
        }

        return artists
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artists: List<Artist>
        try {
            artists = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("error", exception.message.toString())
        }

        if (artists.isEmpty()) {
            artists = getArtistsFromDB()
            artistCacheDataSource.saveArtistsInCache(artists)
        }

        return artists
    }
}