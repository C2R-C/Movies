package com.c2r.movies.repository

import com.c2r.movies.data.model.MovieUIList
import com.c2r.movies.data.model.mapper.MovieMapper
import com.c2r.movies.data.remote.MovieDataSource
import com.c2r.movies.utils.mapToUI


class MovieRepositoryImp(private val movieDataSource: MovieDataSource) : MovieRepository {

    override suspend fun getUpComingMovies(): MovieUIList {
        val movieApiList = movieDataSource.getUpComingMovies().results
        val movieList = movieApiList.mapToUI { movieApi -> MovieMapper.mapToUI(movieApi) }
        return MovieUIList(movieList)
    }
    override suspend fun getTopRatedMovies(): MovieUIList {
        val movieApiList = movieDataSource.getTopRatedMovies().results
        val movieList = movieApiList.mapToUI { movieApi -> MovieMapper.mapToUI(movieApi) }
        return MovieUIList(movieList)
    }

    override suspend fun getPopularMovies(): MovieUIList {
        val movieApiList = movieDataSource.getPopularMovies().results
        val movieList = movieApiList.mapToUI { movieApi -> MovieMapper.mapToUI(movieApi) }
        return MovieUIList(movieList)
    }

}