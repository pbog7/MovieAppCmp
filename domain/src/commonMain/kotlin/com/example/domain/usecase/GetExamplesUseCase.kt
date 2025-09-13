package com.example.domain.usecase

import com.example.domain.models.CustomResult
import com.example.domain.models.ExampleModel
import com.example.domain.repository.ExampleRepository

class GetExamplesUseCase(private val exampleRepository: ExampleRepository): BaseUseCaseNoParams<List<ExampleModel>> {
    override suspend fun invoke(): CustomResult<List<ExampleModel>> =
        exampleRepository.getExamples()
}