package com.example.data

import com.example.data.network.dto.ExampleDto
import com.example.data.network.dto.MovieDto
import com.example.domain.models.ExampleModel
import com.example.domain.models.Movie

fun ExampleDto.toExampleModel() = ExampleModel (
    example = example
)

fun MovieDto.toMovie() = Movie(
    id = id,
    title = title,
    rating = voteAverage.toFloat(),
    thumbnail = posterPath
)