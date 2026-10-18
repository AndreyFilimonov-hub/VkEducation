package com.filimonov.vkeducation.appscreen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.filimonov.vkeducation.listscreen.App
import com.filimonov.vkeducation.listscreen.ui.AppContent
import com.filimonov.vkeducation.listscreen.TestData

@Composable
fun ShowcaseScreen(
    modifier: Modifier = Modifier,
    onShowcaseAppClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Витрина",
            style = MaterialTheme.typography.headlineSmall
        )
        val pagerState = rememberPagerState { 3 }

        HorizontalPager(
            state = pagerState
        ) { page ->
            ShowcaseItem(
                apps = when(page) {
                    1 -> TestData.showcaseFirstPage
                    2 -> TestData.showcaseSecondPage
                    else -> TestData.showcaseThirdPage
                },
                onShowcaseAppClick = onShowcaseAppClick
            )
        }
    }
}

@Composable
private fun ShowcaseItem(
    modifier: Modifier = Modifier,
    apps: List<App>,
    onShowcaseAppClick: () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        AppContent(app = apps[0], onAppClick = onShowcaseAppClick)
        AppContent(app = apps[1], onAppClick = onShowcaseAppClick)
        AppContent(app = apps[2], onAppClick = onShowcaseAppClick)
    }
}