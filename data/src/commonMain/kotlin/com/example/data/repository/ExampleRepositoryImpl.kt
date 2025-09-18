package com.example.data.repository

import com.example.data.network.ApiService
import com.example.domain.models.CustomError
import com.example.domain.models.CustomResult
import com.example.domain.models.ExampleModel
import com.example.domain.repository.ExampleRepository
import io.ktor.client.statement.bodyAsText

class ExampleRepositoryImpl(private val apiService: ApiService): ExampleRepository {
    override suspend fun getExamples(): CustomResult<List<ExampleModel>> {
        return try {
            val response = apiService.getExamples()
            CustomResult.Success(listOf(ExampleModel(response.bodyAsText())))
        } catch (e: Exception){
            println("Exception is $e")
            CustomResult.Failure(CustomError.UnknownError("Exception is ${e.message}"))
        }
    }

}