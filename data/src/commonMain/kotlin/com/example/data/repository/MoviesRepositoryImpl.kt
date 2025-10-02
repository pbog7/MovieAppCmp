package com.example.data.repository

import com.example.data.network.ApiService
import com.example.data.toMovie
import com.example.domain.models.CustomError
import com.example.domain.models.CustomResult
import com.example.domain.models.Movie
import com.example.domain.repository.MoviesRepository

class MoviesRepositoryImpl (private val apiService: ApiService): MoviesRepository {
    override suspend fun getPopularMovies(): CustomResult<List<Movie>> {
        return try {
            val response = apiService.getPopularMovies()
            CustomResult.Success(response.movies.map { it.toMovie() })
        } catch (e: Exception){
            println("Exception is $e")
            CustomResult.Failure(CustomError.UnknownError("Exception is ${e.message}"))
        }
    }

}