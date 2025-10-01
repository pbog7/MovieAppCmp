package com.example.core.extensions

import com.example.core.ActionState
import com.example.domain.models.CustomResult

fun <T> CustomResult<T>.toActionState(): ActionState<T> =
    when (this) {
        is CustomResult.Success -> ActionState(data = this.data, isLoading = false)
        is CustomResult.Failure -> ActionState(error = this.error.message, isLoading = false)
    }