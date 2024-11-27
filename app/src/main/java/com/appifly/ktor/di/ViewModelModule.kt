package com.appifly.ktor.di

import com.appifly.ktor.viewmodel.CategoryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CategoryViewModel(get()) }
}