package com.oligue.app.beerace.ui.beeranking.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.oligue.app.beerace.R
import com.oligue.app.beerace.data.repositories.mockBeeList
import com.oligue.app.beerace.ui.base.model.BeeUI
import com.oligue.app.beerace.ui.theme.BeeRaceTheme
import com.oligue.app.beerace.ui.theme.dimen_16
import com.oligue.app.beerace.ui.theme.dimen_4
import com.oligue.app.beerace.ui.theme.dimen_64
import com.oligue.app.beerace.utils.hexToArgb

@Composable
fun BeeListUI(
    beeList: List<BeeUI>
) {
    LazyColumn{
        items(beeList){ bee ->
            BeeItem(bee)
        }
    }
}

@Composable
fun BeeItem(bee: BeeUI) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        RoundedImage(Color(hexToArgb(bee.color)))

        Column {
            Text(
                modifier = Modifier
                    .padding(top = dimen_4, start = dimen_16, end = dimen_16),
                textAlign = TextAlign.Start,
                text = bee.positionString,
                style = MaterialTheme.typography.bodyLarge,
            )

            Text(
                modifier = Modifier
                    .padding(top = dimen_4, start = dimen_16, end = dimen_16),
                textAlign = TextAlign.Start,
                text = bee.name,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        when(bee.position){
            1 -> {ImageBee(R.drawable.gold)}
            2 -> {ImageBee(R.drawable.silver)}
            3 -> {ImageBee(R.drawable.third)}
        }
    }
}

@Composable
fun ImageBee(drawable : Int) {
    Image(
        painter = painterResource(drawable),
        contentDescription = "gold",
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(dimen_64)
    )
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
fun BeeListUIPreview() {
    BeeRaceTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            BeeListUI(
                beeList = mockBeeList
            )
        }
    }
}