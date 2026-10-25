package com.filimonov.vkeducation.presentation.listscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filimonov.vkeducation.data.repository.AppRepositoryImpl
import com.filimonov.vkeducation.domain.usecase.GetAppsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val repository = AppRepositoryImpl()
    private val getAppsUseCase = GetAppsUseCase(repository)

    private val _state = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    private val _event = MutableSharedFlow<ListEvent>()
    val event = _event.asSharedFlow()

    init {
        getAppsUseCase()
            .onEach { apps ->
                _state.value = ListState(apps)
            }
            .launchIn(viewModelScope)
    }

    fun processCommand(command: ListCommand) {
        when (command) {
            is ListCommand.LogoClick -> {
                viewModelScope.launch {
                    _event.emit(ListEvent.LogoClickEvent(command.appName))
                }
            }
        }
    }
}