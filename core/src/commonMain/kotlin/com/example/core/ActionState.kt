package com.example.core

data class ActionState<T>(
    val data: T? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)
