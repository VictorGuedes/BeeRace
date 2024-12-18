package com.oligue.app.beerace.ui.beeranking.composables

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.oligue.app.beerace.R
import com.oligue.app.beerace.data.repositories.mockBeeList
import com.oligue.app.beerace.ui.base.model.BeeResponseUI
import com.oligue.app.beerace.ui.beeranking.RankingListScreen
import com.oligue.app.beerace.ui.beeranking.viewmodel.BeeRankingContract
import com.oligue.app.beerace.ui.theme.BeeRaceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        }
    )
}

@PreviewLightDark
@Composable
fun TopBarPreview() {
    BeeRaceTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            TopBar()
        }
    }
}