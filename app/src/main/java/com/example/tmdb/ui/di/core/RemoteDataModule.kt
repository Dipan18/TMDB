package com.example.tmdb.ui.di.core

import com.example.tmdb.data.api.TMDBService
import com.example.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdb.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdb.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.tmdb.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.example.tmdb.data.repository.tvshow.datasourceimpl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(tmdbService)

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TVShowRemoteDataSource =
        TVShowRemoteDataSourceImpl(tmdbService)

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource =
        ArtistRemoteDataSourceImpl(tmdbService)
}