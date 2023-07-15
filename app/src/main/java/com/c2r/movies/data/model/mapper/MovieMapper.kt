package com.c2r.movies.data.model.mapper

import com.c2r.movies.data.model.MovieApi
import com.c2r.movies.data.model.MovieUI

object MovieMapper {
    fun mapToUI(movieApi: MovieApi) : MovieUI {
        return MovieUI(
            id = movieApi.id,
            imgBackground = movieApi.backdrop_path,
            imgMovie = movieApi.poster_path,
            language = movieApi.original_language,
            description = movieApi.overview,
            release = movieApi.release_date,
            title = movieApi.title,
            voteAverage = movieApi.vote_average,
            voteCount = movieApi.vote_count
        )
    }
}