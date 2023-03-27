package com.example.tmdb.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.domain.usecase.GetMoviesUseCase
import com.example.tmdb.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    fun getMovies() = liveData {
        val movies = getMoviesUseCase.execute()
        emit(movies)
    }

    fun updateMovies() = liveData {
        val newListOfMovies = updateMoviesUseCase.execute()
        emit(newListOfMovies)
    }
}