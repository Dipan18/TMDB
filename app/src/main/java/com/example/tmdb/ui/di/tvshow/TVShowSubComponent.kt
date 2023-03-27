package com.example.tmdb.ui.di.tvshow

import com.example.tmdb.ui.tvshow.TVShowFragment
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {
    fun inject(tvShowFragment: TVShowFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TVShowSubComponent
    }
}