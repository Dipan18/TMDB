package com.example.tmdb.ui.di.core

import com.example.tmdb.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdb.data.repository.movie.MovieRepositoryImpl
import com.example.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdb.data.repository.tvshow.TVShowRepositoryImpl
import com.example.tmdb.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.example.tmdb.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.example.tmdb.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.example.tmdb.domain.repository.ArtistRepository
import com.example.tmdb.domain.repository.MovieRepository
import com.example.tmdb.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository =
        MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ): TVShowRepository =
        TVShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository =
        ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
}