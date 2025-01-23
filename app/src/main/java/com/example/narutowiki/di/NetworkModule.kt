package com.example.narutowiki.di


import com.example.narutowiki.data.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    single { get<Retrofit>().create(Api::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl("https://narutodb.xyz")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(Api::class.java)

    }
}