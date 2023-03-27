package com.example.tmdb.ui.di.artist

import com.example.tmdb.ui.artist.ArtistFragment
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistFragment: ArtistFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}