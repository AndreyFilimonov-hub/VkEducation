package com.filimonov.vkeducation.presentation.appscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filimonov.vkeducation.domain.usecase.GetAppByIdUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = AppDetailsViewModel.Factory::class)
class AppDetailsViewModel @AssistedInject constructor(
    private val getAppByIdUseCase: GetAppByIdUseCase,
    @Assisted("id") private val id: String
) : ViewModel() {

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            loadAppDetails()
        }
    }

    fun processCommand(command: AppDetailsCommand) {
        when (command) {
            AppDetailsCommand.Retry -> {
                viewModelScope.launch {
                    loadAppDetails()
                }
            }
        }
    }

    private suspend fun loadAppDetails() {
        _state.value = AppDetailsState.Loading
        getAppByIdUseCase(id)
            .onSuccess { appDetails ->
                _state.update {
                    Log.d("AAA", appDetails.toString())
                    AppDetailsState.Content(appDetails)
                }
            }
            .onFailure { throwable ->
                _state.update {
                    Log.d("AAA", throwable.message ?: "")
                    AppDetailsState.Error
                }
            }
    }

    @AssistedFactory
    interface Factory {

        fun create(@Assisted("id") id: String): AppDetailsViewModel
    }
}


