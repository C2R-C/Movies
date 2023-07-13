package com.c2r.movies.repository

import com.c2r.movies.data.model.MovieList

interface MovieRepository {

    suspend fun getUpComingMovies(): MovieList

    suspend fun getTopRatedMovies(): MovieList

    suspend fun getPopularMovies(): MovieList
}