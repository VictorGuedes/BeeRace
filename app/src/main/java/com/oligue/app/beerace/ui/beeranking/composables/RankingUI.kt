package com.oligue.app.beerace.ui.beeranking.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.oligue.app.beerace.data.repositories.mockBeeList
import com.oligue.app.beerace.ui.base.model.BeeUI
import com.oligue.app.beerace.ui.theme.BeeRaceTheme

@Composable
fun RankingUI(
    timeInSeconds: String,
    beeList: List<BeeUI>,
    modifier: Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Timer(timeInSeconds = timeInSeconds)
        BeeListUI(beeList = beeList)
    }
}


@PreviewLightDark
@PreviewScreenSizes
@Composable
fun RankingUIPreview() {
    BeeRaceTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            RankingUI(
                timeInSeconds = "00 : 00",
                beeList = mockBeeList,
                modifier = Modifier
            )
        }
    }
}