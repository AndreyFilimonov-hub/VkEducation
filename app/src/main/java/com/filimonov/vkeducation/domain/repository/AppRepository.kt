package com.filimonov.vkeducation.domain.repository

import com.filimonov.vkeducation.domain.entity.App
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getApps(): Flow<List<App>>
}