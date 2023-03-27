package com.example.tmdb.ui.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.domain.usecase.GetArtistsUseCase
import com.example.tmdb.domain.usecase.UpdateArtistsUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
}