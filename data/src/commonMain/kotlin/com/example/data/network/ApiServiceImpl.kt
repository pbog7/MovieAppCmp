package com.example.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class ApiServiceImpl(private val httpClient: HttpClient): ApiService {
    override suspend fun getExamples() = httpClient.get("posts/1")
}