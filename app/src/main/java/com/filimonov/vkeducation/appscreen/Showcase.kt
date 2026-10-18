package com.filimonov.vkeducation.appscreen

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
import com.filimonov.vkeducation.App
import com.filimonov.vkeducation.listscreen.AppContent
import com.filimonov.vkeducation.listscreen.TestData

@Composable
fun ShowcaseScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .padding(vertical = 16.dp),
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
                }
            )
        }
    }
}

@Composable
private fun ShowcaseItem(
    modifier: Modifier = Modifier,
    apps: List<App>
) {
    Column(modifier = modifier.fillMaxWidth()) {
        AppContent(app = apps[0])
        AppContent(app = apps[1])
        AppContent(app = apps[2])
    }
}