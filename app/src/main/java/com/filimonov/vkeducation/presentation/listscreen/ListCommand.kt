package com.filimonov.vkeducation.presentation.listscreen

sealed interface ListCommand {

    data class LogoClick(val appId: Int): ListCommand
}