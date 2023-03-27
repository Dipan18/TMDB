package com.example.tmdb.ui.di.movie

import com.example.tmdb.domain.usecase.GetMoviesUseCase
import com.example.tmdb.domain.usecase.UpdateMoviesUseCase
import com.example.tmdb.ui.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory =
        MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
}