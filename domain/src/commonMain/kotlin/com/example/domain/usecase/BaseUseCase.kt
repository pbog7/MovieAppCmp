package com.example.domain.usecase

import com.example.domain.models.CustomResult

interface BaseUseCase<out T, in Params> {

    suspend operator fun invoke(params:Params): CustomResult<T>
}