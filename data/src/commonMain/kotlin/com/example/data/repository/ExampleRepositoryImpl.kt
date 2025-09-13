package com.example.data.repository

import com.example.domain.models.CustomResult
import com.example.domain.models.ExampleModel
import com.example.domain.repository.ExampleRepository

class ExampleRepositoryImpl: ExampleRepository {
    override fun getExamples(): CustomResult<List<ExampleModel>> {
        return CustomResult.Success(listOf(ExampleModel("example1")))
    }

}