package com.example.movieappcmp

import android.app.Application
import com.example.movieappcmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class MovieAppCmpApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MovieAppCmpApplication)
        }
    }
}