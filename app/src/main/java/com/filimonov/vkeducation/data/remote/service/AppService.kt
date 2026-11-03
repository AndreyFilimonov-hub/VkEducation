package com.filimonov.vkeducation.data.remote.service

import com.filimonov.vkeducation.data.remote.dto.AppDto
import retrofit2.http.GET

interface AppService {

    @GET("catalog")
    suspend fun getApps(): List<AppDto>
}
