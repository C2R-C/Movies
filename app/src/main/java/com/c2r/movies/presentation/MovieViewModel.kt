package com.c2r.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.c2r.movies.core.Resource
import com.c2r.movies.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(Triple(
                repository.getUpComingMovies()
                ,repository.getTopRatedMovies()
                ,repository.getPopularMovies()))
            )
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}