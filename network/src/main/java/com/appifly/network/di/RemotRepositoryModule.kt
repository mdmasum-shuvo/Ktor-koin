package com.appifly.network.di

import com.appifly.network.remote_data.repository.GetAllCategoryApiUseCase
import com.appifly.network.remote_data.repository.GetAllCategoryApiUseCaseImpl
import com.appifly.network.remote_data.repository.NetworkDataRepository
import com.appifly.network.remote_data.repository.RemoteRepositoryImpl
import org.koin.dsl.module

val remoteRepositoryModule = module {
    single<NetworkDataRepository> { RemoteRepositoryImpl(get(), get()) }
    single<GetAllCategoryApiUseCase> { GetAllCategoryApiUseCaseImpl(get()) }

}