package com.example.data

import com.example.data.network.dto.ExampleDto
import com.example.domain.models.ExampleModel

fun ExampleDto.toExampleModel() = ExampleModel (
    example = example
)