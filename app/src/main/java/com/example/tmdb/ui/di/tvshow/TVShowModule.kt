package com.example.tmdb.ui.di.tvshow

import com.example.tmdb.domain.usecase.GetTvShowsUseCase
import com.example.tmdb.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdb.ui.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {
    @TVShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TVShowViewModelFactory =
        TVShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
}