package com.example.narutowiki.di

import com.example.narutowiki.data.AnimeRepositoryImpl
import com.example.narutowiki.domain.AnimeRepository
import com.example.narutowiki.domain.use_cases.GetAnimeUseCase
import com.example.narutowiki.presentation.AnimeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import org.koin.dsl.single

val appModule = module {

    single<AnimeRepository> {
        AnimeRepositoryImpl(get())
    }
    single { AnimeViewModel(get()) }
}