package com.filimonov.vkeducation.presentation.appscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.filimonov.vkeducation.domain.entity.AppDetails

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
    id: String,
    viewModel: AppDetailsViewModel = hiltViewModel(
        creationCallback = { factory: AppDetailsViewModel.Factory ->
            factory.create(id)
        }
    ),
    onBackClick: () -> Unit
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state.value) {
        is AppDetailsState.Content -> {
            AppDetailsContent(
                modifier = modifier,
                appDetails = currentState.appDetails,
                onBackClick = onBackClick,
                onShareClick = {},
                onInstallClick = {},
                onDeveloperClick = {}
            )
        }

        AppDetailsState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        viewModel.processCommand(AppDetailsCommand.Retry)
                    },
                    content = {
                        Text("Повторить")
                    }
                )
            }
        }
        AppDetailsState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }


}

@Composable
private fun AppDetailsContent(
    modifier: Modifier = Modifier,
    appDetails: AppDetails,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onInstallClick: () -> Unit,
    onDeveloperClick: () -> Unit,
) {
    Scaffold { innerPadding ->
        Column(modifier
            .padding(top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding())
            .verticalScroll(rememberScrollState())
        ) {
            Toolbar(
                onBackClick = onBackClick,
                onShareClick = onShareClick,
            )
            Spacer(Modifier.height(8.dp))
            AppDetailsHeader(
                appDetails = appDetails,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
            Spacer(Modifier.height(16.dp))
            InstallButton(
                onClick = onInstallClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(Modifier.height(12.dp))
            ScreenshotsList(
                screenshotUrlList = appDetails.screenshotUrlList,
                contentPadding = PaddingValues(horizontal = 16.dp),
            )
            Spacer(Modifier.height(12.dp))
            AppDescription(
                description = appDetails.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            )
            Spacer(Modifier.height(12.dp))
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.outlineVariant,
            )
            Spacer(Modifier.height(12.dp))
            Developer(
                name = appDetails.developer,
                onClick = onDeveloperClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
            )
        }
    }
}
