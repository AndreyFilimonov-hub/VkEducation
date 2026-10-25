package com.filimonov.vkeducation.domain.usecase

import com.filimonov.vkeducation.domain.entity.App
import com.filimonov.vkeducation.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow

class GetAppsUseCase(
    private val repository: AppRepository
) {

    operator fun invoke(): Flow<List<App>> {
        return repository.getApps()
    }
}