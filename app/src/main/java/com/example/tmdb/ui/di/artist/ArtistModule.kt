package com.example.tmdb.ui.di.artist

import com.example.tmdb.domain.usecase.GetArtistsUseCase
import com.example.tmdb.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb.ui.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory =
        ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
}