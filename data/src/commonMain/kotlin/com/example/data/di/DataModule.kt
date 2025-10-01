package com.example.data.di

import com.example.data.network.ApiService
import com.example.data.network.ApiServiceImpl
import com.example.data.network.httpLogger
import com.example.data.repository.ExampleRepositoryImpl
import com.example.domain.repository.ExampleRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(DefaultRequest) {
                url("https://jsonplaceholder.typicode.com/")
            }
            install(ContentNegotiation) {
                json()
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
}
