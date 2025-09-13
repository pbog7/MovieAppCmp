package com.example.domain.usecase

import com.example.domain.models.CustomResult

interface BaseUseCaseNoParams<out T> {

    suspend operator fun invoke(): CustomResult<T>
}