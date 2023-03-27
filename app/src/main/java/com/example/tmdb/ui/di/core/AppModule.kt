package com.example.tmdb.ui.di.core

import android.content.Context
import com.example.tmdb.ui.di.artist.ArtistSubComponent
import com.example.tmdb.ui.di.movie.MovieSubComponent
import com.example.tmdb.ui.di.tvshow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TVShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}