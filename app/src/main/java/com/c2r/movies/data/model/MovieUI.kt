package com.c2r.movies.data.model

data class MovieUI(
    val id: Int = -1,
    val imgBackground: String = "",
    val imgMovie: String = "",
    val language: String = "",
    val description: String = "",
    val release: String = "",
    val title: String = "",
    val voteAverage: Double = -1.0,
    val voteCount: Int = -1
)
