package com.filimonov.vkeducation.presentation.appscreen

sealed interface AppDetailsCommand {

    data object Retry : AppDetailsCommand
}
