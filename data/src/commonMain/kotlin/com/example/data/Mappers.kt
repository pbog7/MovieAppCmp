package com.example.data

import com.example.data.network.dto.ExampleDto
import com.example.data.network.dto.MovieDto
import com.example.data.utils.ImageSizeAlias
import com.example.data.utils.UrlUtils
import com.example.domain.models.ExampleModel
import com.example.domain.models.ImageType
import com.example.domain.models.Movie

fun ExampleDto.toExampleModel() = ExampleModel(
    example = example
)

fun MovieDto.toMovie() = Movie(
    id = id,
    title = title,
    rating = voteAverage.toFloat(),
    thumbnail = UrlUtils.buildImageUrl(
        type = ImageType.POSTER,
        size = ImageSizeAlias.MEDIUM,
        path = posterPath
    )
)