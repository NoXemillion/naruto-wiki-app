package com.example.narutowiki.di

import com.example.narutowiki.domain.use_cases.GetAnimeUseCase
import org.koin.dsl.module


val useCaseModule = module {
    factory { GetAnimeUseCase(get()) }
}