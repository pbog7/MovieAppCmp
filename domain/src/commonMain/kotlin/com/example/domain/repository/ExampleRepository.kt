package com.example.domain.repository

import com.example.domain.models.CustomResult
import com.example.domain.models.ExampleModel

interface ExampleRepository {
    suspend fun getExamples(): CustomResult<List<ExampleModel>>
}
