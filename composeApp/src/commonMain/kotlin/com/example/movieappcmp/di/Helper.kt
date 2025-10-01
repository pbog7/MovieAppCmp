package com.example.movieappcmp.di

import com.example.data.di.dataModule
import com.example.homescreen.di.homeScreenModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        dataModule,
        domainModule,
        homeScreenModule
        // add other modules here
    )
}