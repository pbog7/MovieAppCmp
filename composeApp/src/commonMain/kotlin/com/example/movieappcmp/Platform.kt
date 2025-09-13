package com.example.movieappcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform