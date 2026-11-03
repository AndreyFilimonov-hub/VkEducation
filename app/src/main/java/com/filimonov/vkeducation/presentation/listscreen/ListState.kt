package com.filimonov.vkeducation.presentation.listscreen

import com.filimonov.vkeducation.domain.entity.App

data class ListState(
    val apps: List<App> = emptyList()
)
