package com.appifly.network.di

import org.koin.dsl.module


val appModule = module {
    includes(remoteDataSourceModule)
}