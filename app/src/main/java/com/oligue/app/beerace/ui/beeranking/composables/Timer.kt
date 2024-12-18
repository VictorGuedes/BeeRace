package com.oligue.app.beerace.ui.beeranking.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.oligue.app.beerace.R
import com.oligue.app.beerace.ui.theme.BeeRaceTheme
import com.oligue.app.beerace.ui.theme.dimen_16
import com.oligue.app.beerace.ui.theme.dimen_4


@Composable
fun Timer(timeInSeconds: String) {
    Text(
        modifier = Modifier.fillMaxWidth()
            .padding(top = dimen_16, start = dimen_16, end = dimen_16),
        textAlign = TextAlign.Center,
        text = stringResource(R.string.time_remaining_tex),
        style = MaterialTheme.typography.bodyLarge,
    )

    Text(
        modifier = Modifier.fillMaxWidth()
            .padding(top = dimen_4, start = dimen_16, end = dimen_16),
        textAlign = TextAlign.Center,
        text = timeInSeconds,
        style = MaterialTheme.typography.bodyLarge,
    )
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
fun TimerPreview() {
    BeeRaceTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Timer(timeInSeconds = "00 : 00")
        }
    }
}