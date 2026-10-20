package com.filimonov.vkeducation.presentation.listscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filimonov.vkeducation.data.TestData
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<ListEvent>()
    val event = _event.asSharedFlow()

    init {
        _state.value = ListState(TestData.apps)
    }

    fun processCommand(command: ListCommand) {
        when (command) {
            is ListCommand.LogoClick -> {
                viewModelScope.launch {
                    val appName = TestData.apps.find { app -> app.id == command.appId }?.name
                        ?: throw RuntimeException()

                    _event.emit(ListEvent.LogoClickEvent(appName))
                }
            }
        }
    }
}