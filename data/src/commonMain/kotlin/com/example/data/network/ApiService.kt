package com.example.data.network

import com.example.data.network.response.PopularMoviesResponse
import io.ktor.client.statement.HttpResponse

interface ApiService {
    suspend fun getExamples(): HttpResponse

    suspend fun getPopularMovies(): PopularMoviesResponse

}