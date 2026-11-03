package com.filimonov.vkeducation.di

import com.filimonov.vkeducation.data.remote.service.AppService
import com.filimonov.vkeducation.data.repository.AppRepositoryImpl
import com.filimonov.vkeducation.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindAppRepository(repositoryImpl: AppRepositoryImpl): AppRepository

    companion object {

        @Singleton
        @Provides
        fun provideJson(): Json {
            return Json {
                ignoreUnknownKeys = true
            }
        }

        @Singleton
        @Provides
        fun provideConverterFactory(json: Json): Converter.Factory {
            return json.asConverterFactory("application/json".toMediaType())
        }

        @Singleton
        @Provides
        fun provideRetrofit(converterFactory: Converter.Factory): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://185.103.109.134/")
                .addConverterFactory(converterFactory)
                .build()
        }

        @Singleton
        @Provides
        fun provideAppService(retrofit: Retrofit): AppService {
            return retrofit.create(AppService::class.java)
        }
    }
}
