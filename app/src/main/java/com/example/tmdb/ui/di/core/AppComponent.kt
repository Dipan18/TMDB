package com.example.tmdb.ui.di.core

import com.example.tmdb.ui.di.artist.ArtistSubComponent
import com.example.tmdb.ui.di.movie.MovieSubComponent
import com.example.tmdb.ui.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TVShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}