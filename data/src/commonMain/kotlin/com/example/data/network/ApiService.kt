package com.example.data.network

import io.ktor.client.statement.HttpResponse

interface ApiService {
    suspend fun getExamples(): HttpResponse
}