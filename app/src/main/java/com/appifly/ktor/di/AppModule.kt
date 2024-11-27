package com.appifly.ktor.di

import com.appifly.network.di.dispatchersModule
import com.appifly.network.di.remoteDataSourceModule
import com.appifly.network.di.remoteRepositoryModule
import org.koin.dsl.module

val appModule = module {
    includes(remoteDataSourceModule,dispatchersModule, remoteRepositoryModule, viewModelModule)
}