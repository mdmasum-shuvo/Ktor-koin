package com.appifly.ktor.di

import com.appifly.ktor.viewmodel.HomeViewModel
import com.appifly.ktor.viewmodel.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(),get()) }
    viewModel { SearchViewModel() }
}