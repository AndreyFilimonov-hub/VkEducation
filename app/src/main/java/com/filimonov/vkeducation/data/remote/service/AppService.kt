package com.filimonov.vkeducation.data.remote.service

import com.filimonov.vkeducation.data.remote.dto.AppDetailsDto
import com.filimonov.vkeducation.data.remote.dto.AppDto
import retrofit2.http.GET
import retrofit2.http.Query

interface AppService {

    @GET("catalog")
    suspend fun getApps(): List<AppDto>

    @GET("catalog/{id}")
    suspend fun getAppById(@Query("id") id: String): AppDetailsDto
}
