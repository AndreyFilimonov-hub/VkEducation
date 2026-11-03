package com.filimonov.vkeducation.domain.usecase

import com.filimonov.vkeducation.domain.entity.AppDetails
import com.filimonov.vkeducation.domain.repository.AppRepository
import javax.inject.Inject

class GetAppByIdUseCase @Inject constructor(
    private val repository: AppRepository
) {

    suspend operator fun invoke(id: String): Result<AppDetails> {
        return runCatching {
            repository.getAppById(id)
        }
    }
}
