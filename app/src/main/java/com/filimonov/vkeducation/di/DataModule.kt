package com.filimonov.vkeducation.di

import com.filimonov.vkeducation.data.repository.AppRepositoryImpl
import com.filimonov.vkeducation.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindAppRepository(repositoryImpl: AppRepositoryImpl): AppRepository
}