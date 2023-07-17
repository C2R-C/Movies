package com.c2r.movies.utils

import com.c2r.movies.data.model.MovieApi
import com.c2r.movies.data.model.MovieUI
import com.c2r.movies.data.model.MovieUIList
import com.c2r.movies.data.model.mapper.MovieMapper

fun <A, B>List<A>.mapTo(mapper: (A) -> B): List<B> {
    return this.map { item -> mapper(item) }
}