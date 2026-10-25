package com.filimonov.vkeducation.presentation.listscreen

sealed interface ListEvent {

    data class LogoClickEvent(val appName: String) : ListEvent
}