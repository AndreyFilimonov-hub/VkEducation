package com.filimonov.vkeducation.data.repository

import com.filimonov.vkeducation.data.mapper.toEntity
import com.filimonov.vkeducation.data.remote.dto.AppDto
import com.filimonov.vkeducation.data.remote.service.AppService
import com.filimonov.vkeducation.domain.entity.App
import com.filimonov.vkeducation.domain.entity.AppDetails
import com.filimonov.vkeducation.domain.repository.AppRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl @Inject constructor(
    private val appService: AppService
) : AppRepository {

    override fun getApps(): Flow<List<App>> {
        return flow { emit(appService.getApps().map(AppDto::toEntity)) }
    }

    override suspend fun getAppById(id: String): AppDetails {
        return appService.getAppById(id).toEntity()
    }
}
