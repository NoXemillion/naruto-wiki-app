package com.example.narutowiki

import android.app.Application
import com.example.narutowiki.di.appModule
import com.example.narutowiki.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(networkModule, appModule))
        }
    }

}