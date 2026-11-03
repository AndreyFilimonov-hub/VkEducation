package com.filimonov.vkeducation.domain.repository

import com.filimonov.vkeducation.domain.entity.App
import com.filimonov.vkeducation.domain.entity.AppDetails
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getApps(): Flow<List<App>>

    suspend fun getAppById(id: String): AppDetails
}
