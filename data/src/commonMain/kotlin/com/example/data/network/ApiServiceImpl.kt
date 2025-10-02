package com.example.data.network

import com.example.data.network.response.PopularMoviesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiServiceImpl(private val httpClient: HttpClient) : ApiService {
    override suspend fun getExamples() = httpClient.get("posts/1")
    override suspend fun getPopularMovies(): PopularMoviesResponse = httpClient.get("movie/popular").body()
}