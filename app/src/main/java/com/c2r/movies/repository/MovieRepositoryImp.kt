package com.c2r.movies.repository

import com.c2r.movies.data.model.MovieList
import com.c2r.movies.data.remote.MovieDataSource

class MovieRepositoryImp(private val movieDataSource: MovieDataSource) : MovieRepository {

    override suspend fun getUpComingMovies(): MovieList = movieDataSource.getUpComingMovies()

    override suspend fun getTopRatedMovies(): MovieList = movieDataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = movieDataSource.getPopularMovies()

}