package com.example.tmdb.ui

import android.app.Application
import com.example.tmdb.BuildConfig
import com.example.tmdb.ui.di.Injector
import com.example.tmdb.ui.di.artist.ArtistSubComponent
import com.example.tmdb.ui.di.core.AppComponent
import com.example.tmdb.ui.di.core.AppModule
import com.example.tmdb.ui.di.core.DaggerAppComponent
import com.example.tmdb.ui.di.core.NetModule
import com.example.tmdb.ui.di.movie.MovieSubComponent
import com.example.tmdb.ui.di.tvshow.TVShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL, BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent =
        appComponent.movieSubComponent().create()

    override fun createTvShowSubComponent(): TVShowSubComponent =
        appComponent.tvShowSubComponent().create()

    override fun createArtistSubComponent(): ArtistSubComponent =
        appComponent.artistSubComponent().create()
}