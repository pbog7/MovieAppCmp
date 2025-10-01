package com.example.homescreen.di

import com.example.homescreen.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeScreenModule = module {
    viewModel { HomeViewModel(get()) }
}
