package com.example.tmdb.ui.di.core

import com.example.tmdb.data.db.ArtistDao
import com.example.tmdb.data.db.MovieDao
import com.example.tmdb.data.db.TVShowDao
import com.example.tmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdb.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.tmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.tmdb.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.example.tmdb.data.repository.tvshow.datasourceimpl.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao)

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TVShowDao): TVShowLocalDataSource =
        TVShowLocalDataSourceImpl(tvShowDao)

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource =
        ArtistLocalDataSourceImpl(artistDao)
}