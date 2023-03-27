package com.example.tmdb.ui.di

import com.example.tmdb.ui.di.artist.ArtistSubComponent
import com.example.tmdb.ui.di.movie.MovieSubComponent
import com.example.tmdb.ui.di.tvshow.TVShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TVShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}