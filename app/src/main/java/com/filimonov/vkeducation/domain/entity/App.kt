package com.filimonov.vkeducation.domain.entity

data class App(
    val id: Int,
    val name: String,
    val description: String,
    val category: Category,
    val iconResId: Int
)
