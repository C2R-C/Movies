package com.c2r.movies.data.remote

import com.c2r.movies.application.AppConstants
import com.c2r.movies.data.model.MovieApiList
import com.c2r.movies.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpComingMovies(): MovieApiList = webService.getUpcomingMovies(AppConstants.API_KEY, AppConstants.SPANISH)

    suspend fun getTopRatedMovies(): MovieApiList = webService.getTopRatedMovies(AppConstants.API_KEY, AppConstants.SPANISH)

    suspend fun getPopularMovies(): MovieApiList = webService.getPopularMovies(AppConstants.API_KEY, AppConstants.SPANISH)
}