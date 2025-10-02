package com.example.domain.usecase

import com.example.domain.models.CustomResult
import com.example.domain.models.Movie
import com.example.domain.repository.MoviesRepository

class GetPopularMoviesUseCase(private val moviesRepository: MoviesRepository) :
    BaseUseCaseNoParams<List<Movie>> {
    override suspend fun invoke(): CustomResult<List<Movie>> =
        moviesRepository.getPopularMovies()
}