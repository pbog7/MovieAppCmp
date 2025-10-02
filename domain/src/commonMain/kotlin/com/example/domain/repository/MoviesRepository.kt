package com.example.domain.repository

import com.example.domain.models.CustomResult
import com.example.domain.models.Movie

interface MoviesRepository {
    suspend fun getPopularMovies(): CustomResult<List<Movie>>
}