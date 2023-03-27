package com.example.tmdb.ui.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdb.data.db.ArtistDao
import com.example.tmdb.data.db.MovieDao
import com.example.tmdb.data.db.TMDBDatabase
import com.example.tmdb.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase =
        Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao = tmdbDatabase.movieDao()

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TVShowDao = tmdbDatabase.tvShowDao()

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao = tmdbDatabase.artistDao()
}