package com.example.data.di

import com.example.data.network.ApiService
import com.example.data.network.ApiServiceImpl
import com.example.data.network.httpLogger
import com.example.data.repository.ExampleRepositoryImpl
import com.example.data.repository.MoviesRepositoryImpl
import com.example.domain.repository.ExampleRepository
import com.example.domain.repository.MoviesRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module
import com.example.movieappcmp.BuildKonfig
import io.ktor.client.request.header
import kotlinx.serialization.json.Json

val dataModule = module {
    single {
        HttpClient {
            install(DefaultRequest) {
                header("Authorization", "Bearer ${BuildKonfig.API_KEY}")
                url(BuildKonfig.BASE_URL)
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        httpLogger.i { message }
                    }
                }
                level = LogLevel.ALL
            }

        }
    }
    single<ApiService> { ApiServiceImpl(get()) }
    single<ExampleRepository> { ExampleRepositoryImpl(get()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }

}
