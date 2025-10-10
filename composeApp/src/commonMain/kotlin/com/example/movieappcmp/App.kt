package com.example.movieappcmp

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.memory.MemoryCache
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade
import com.example.movieappcmp.theme.AppTheme
import io.ktor.client.HttpClient
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    val httpClient: HttpClient = koinInject()
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context).crossfade(true)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, 0.25)
                    .build()
            }
            .components {
                add(KtorNetworkFetcherFactory(httpClient))
            }
            .build()

    }
    AppTheme {
        MainScreen()
    }
}