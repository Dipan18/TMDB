package com.example.tmdb.data.repository.movie

import android.util.Log
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdb.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie> = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.deleteAllMovies()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movies: List<Movie>
        try {
            val response = movieRemoteDataSource.getMoviesFromAPI()
            val body = response.body()
            if (body != null) {
                movies = body.movies
            }
        } catch (exception: Exception) {
            Log.i("error", exception.message.toString())
        }

        return movies
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movies: List<Movie>
        try {
            movies = movieLocalDataSource.getMoviesFromDB()
        } catch(exception: Exception) {
            Log.i("error", exception.message.toString())
        }

        if (movies.isEmpty()) {
            movies = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movies)
        }

        return movies
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movies: List<Movie>
        try {
            movies = movieCacheDataSource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("error", exception.message.toString())
        }

        if (movies.isEmpty()) {
            movies = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movies)
        }

        return movies
    }
}