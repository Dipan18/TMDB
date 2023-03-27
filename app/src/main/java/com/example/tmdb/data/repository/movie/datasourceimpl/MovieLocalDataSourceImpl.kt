package com.example.tmdb.data.repository.movie.datasourceimpl

import com.example.tmdb.data.db.MovieDao
import com.example.tmdb.data.model.movie.Movie
import com.example.tmdb.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getAllMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun deleteAllMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}