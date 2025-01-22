package com.example.narutowiki.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://narutodb.xyz")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
}