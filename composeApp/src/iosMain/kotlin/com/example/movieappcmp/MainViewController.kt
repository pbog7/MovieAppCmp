package com.example.movieappcmp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.movieappcmp.di.initKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}