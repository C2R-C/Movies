package com.c2r.movies.data.model

data class MovieApi(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = -1,
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1
)
