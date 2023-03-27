package com.example.tmdb.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.domain.usecase.GetTvShowsUseCase
import com.example.tmdb.domain.usecase.UpdateTvShowsUseCase

class TVShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {
    fun getTvShows() = liveData {
        val tvShows = getTvShowsUseCase.execute()
        emit(tvShows)
    }

    fun updateTvShows() = liveData {
        val newListOfTvShows = updateTvShowsUseCase.execute()
        emit(newListOfTvShows)
    }
}