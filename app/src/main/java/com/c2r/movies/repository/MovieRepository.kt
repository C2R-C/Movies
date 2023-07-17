package com.c2r.movies.repository

import com.c2r.movies.data.model.MovieUI
import com.c2r.movies.data.model.MovieUIList

interface MovieRepository {

    suspend fun getUpComingMovies(): MovieUIList

    suspend fun getTopRatedMovies(): MovieUIList

    suspend fun getPopularMovies(): MovieUIList
}