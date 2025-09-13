package com.example.domain.models

sealed class CustomError : Exception() {
    data class EmptyList(override val message: String = "Empty list") : CustomError()
    data class UnknownError(override val message: String = "Something went wrong") : CustomError()
    data class NetworkError(override val message: String = "Something went wrong") : CustomError()
}