package com.example.data.network.response

import com.example.data.network.dto.MovieDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesResponse(
    @SerialName("page") val page:Int,
    @SerialName("results") val movies:List<MovieDto>,
    @SerialName("total_pages") val totalPages:Int,
    @SerialName("total_results") val totalMovies:Int
)
