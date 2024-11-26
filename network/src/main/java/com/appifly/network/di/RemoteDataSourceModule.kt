package com.appifly.network.di

import com.appifly.network.remote_data.RemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { RemoteDataSource(KtorHttpClient().get()) }

}
