package com.example.tmdb.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.domain.usecase.GetTvShowsUseCase
import com.example.tmdb.domain.usecase.UpdateTvShowsUseCase

class TVShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        TVShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
}