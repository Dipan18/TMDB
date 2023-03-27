package com.example.tmdb.data.api

import com.example.tmdb.data.model.artist.ArtistList
import com.example.tmdb.data.model.movie.MovieList
import com.example.tmdb.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(): Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(): Response<ArtistList>
}