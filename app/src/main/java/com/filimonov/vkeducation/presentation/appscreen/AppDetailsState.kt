package com.filimonov.vkeducation.presentation.appscreen

import androidx.compose.runtime.Immutable
import com.filimonov.vkeducation.domain.entity.AppDetails

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
