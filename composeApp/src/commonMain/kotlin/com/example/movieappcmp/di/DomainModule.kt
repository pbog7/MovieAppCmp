package com.example.movieappcmp.di

import com.example.domain.usecase.GetExamplesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetExamplesUseCase(get()) }
}