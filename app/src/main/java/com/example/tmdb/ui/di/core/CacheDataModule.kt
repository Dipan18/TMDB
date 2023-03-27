package com.example.tmdb.ui.di.core

import com.example.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdb.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.tmdb.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.example.tmdb.data.repository.tvshow.datasourceimpl.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource = MovieCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TVShowCacheDataSource = TVShowCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource = ArtistCacheDataSourceImpl()
}