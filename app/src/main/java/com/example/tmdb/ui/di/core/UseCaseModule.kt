package com.example.tmdb.ui.di.core

import com.example.tmdb.domain.repository.ArtistRepository
import com.example.tmdb.domain.repository.MovieRepository
import com.example.tmdb.domain.repository.TVShowRepository
import com.example.tmdb.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase =
        GetMoviesUseCase(movieRepository)

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase =
        UpdateMoviesUseCase(movieRepository)

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TVShowRepository): GetTvShowsUseCase =
        GetTvShowsUseCase(tvShowRepository)

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TVShowRepository): UpdateTvShowsUseCase =
        UpdateTvShowsUseCase(tvShowRepository)

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase =
        GetArtistsUseCase(artistRepository)

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase =
        UpdateArtistsUseCase(artistRepository)
}