package com.filimonov.vkeducation.data.dto

import com.filimonov.vkeducation.domain.entity.Category

data class AppDto(
    val id: Int,
    val name: String,
    val description: String,
    val category: Category,
    val iconResId: Int
)
