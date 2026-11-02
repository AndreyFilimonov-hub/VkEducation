package com.filimonov.vkeducation.data.mapper

import com.filimonov.vkeducation.data.dto.AppDto
import com.filimonov.vkeducation.domain.entity.App

fun AppDto.toEntity(): App {
    return App(id, name, description, category, iconResId)
}