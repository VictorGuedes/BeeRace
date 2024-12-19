package com.oligue.app.beerace.ui.beeranking.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.oligue.app.beerace.R
import com.oligue.app.beerace.ui.beeranking.viewmodel.BeeRankingContract
import com.oligue.app.beerace.ui.theme.BeeRaceTheme
import com.oligue.app.beerace.ui.theme.dimen_16

@Composable
fun ErrorUI(
    modifier: Modifier,
    onEventSent: (event: BeeRankingContract.Event) -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(dimen_16),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.error_title),
            style = MaterialTheme.typography.bodyLarge,
        )

        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(top = dimen_16, start = dimen_16, end = dimen_16),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.error_text),
            style = MaterialTheme.typography.bodyLarge,
        )

        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(top = dimen_16, start = dimen_16, end = dimen_16),
            onClick = {
                onEventSent(BeeRankingContract.Event.startRace)
            }
        ) {
            Text(stringResource(R.string.re_start_race))
        }
    }
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
fun ErrorUIPreview() {
    BeeRaceTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ErrorUI(Modifier, {})
        }
    }
}