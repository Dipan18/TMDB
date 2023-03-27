package com.example.tmdb.ui.di.movie

import com.example.tmdb.ui.movie.MovieFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieFragment: MovieFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}