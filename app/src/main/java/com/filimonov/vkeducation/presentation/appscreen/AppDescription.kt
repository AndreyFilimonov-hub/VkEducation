package com.filimonov.vkeducation.presentation.appscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.filimonov.vkeducation.R
import com.filimonov.vkeducation.presentation.ui.theme.VkEducationTheme

@Composable
fun AppDescription(
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(text = stringResource(R.string.app_details_description))
        Spacer(Modifier.height(8.dp))
        Text(
            text = description,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
private fun PreviewShort() {
    VkEducationTheme {
        AppDescription(
            description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
        )
    }
}

@Preview
@Composable
private fun PreviewCollapsed() {
    VkEducationTheme {
        AppDescription(
            description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
        )
    }
}
