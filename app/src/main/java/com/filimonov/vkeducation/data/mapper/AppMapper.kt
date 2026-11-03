package com.filimonov.vkeducation.data.mapper

import com.filimonov.vkeducation.data.remote.dto.AppDetailsDto
import com.filimonov.vkeducation.data.remote.dto.AppDto
import com.filimonov.vkeducation.domain.entity.App
import com.filimonov.vkeducation.domain.entity.AppDetails

fun AppDto.toEntity(): App {
    return App(id, name, description, category, iconUrl)
}

fun AppDetailsDto.toEntity(): AppDetails {
    return AppDetails(
        id,
        name,
        developer,
        category,
        ageRating,
        size,
        iconUrl,
        screenshotUrlList,
        description
    )
}
