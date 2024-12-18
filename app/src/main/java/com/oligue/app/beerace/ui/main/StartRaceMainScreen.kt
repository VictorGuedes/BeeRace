package com.oligue.app.beerace.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.oligue.app.beerace.R
import com.oligue.app.beerace.ui.base.SIDE_EFFECTS_KEY
import com.oligue.app.beerace.ui.main.viewmodel.MainContract
import com.oligue.app.beerace.ui.theme.BeeRaceTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun StarRaceMainScreen(
    effectFlow: Flow<MainContract.Effect>?,
    onEventSent: (event: MainContract.Event) -> Unit,
    onNavigationRequested: (navigationEffect: MainContract.Effect.Navigation) -> Unit
) {

    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is MainContract.Effect.Navigation.goToRankingScren -> {
                    onNavigationRequested(effect)
                }

            }
        }?.collect()
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { onEventSent(MainContract.Event.goToRankingScreen) }
            ) {
                Text(stringResource(R.string.start_text))
            }
        }
    }
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
fun StarRaceMainScreenPreview() {
    BeeRaceTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            StarRaceMainScreen(
                effectFlow = null,
                onEventSent = {},
                onNavigationRequested = {},
            )
        }
    }
}