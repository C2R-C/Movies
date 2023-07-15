package com.c2r.movies.utils

import com.c2r.movies.data.model.MovieApi
import com.c2r.movies.data.model.MovieUI
import com.c2r.movies.data.model.MovieUIList
import com.c2r.movies.data.model.mapper.MovieMapper

fun List<MovieApi>.mapToUI(mapper: (MovieApi) -> MovieUI): List<MovieUI> {
    return this.map { movie -> mapper(movie) }
}