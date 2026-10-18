package com.filimonov.vkeducation.appscreen.ui

import androidx.compose.runtime.Immutable
import com.filimonov.vkeducation.appscreen.AppDetails
import com.filimonov.vkeducation.appscreen.SimilarApp

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val similarApps: List<SimilarApp>,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}