package com.oligue.app.beerace.ui.beeranking.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.oligue.app.beerace.R
import com.oligue.app.beerace.ui.theme.BeeRaceTheme
import com.oligue.app.beerace.ui.theme.dimen_64
import com.oligue.app.beerace.utils.hexToArgb


@Composable
fun RoundedImage(
    color: Color
) {

    Image(
        painter = painterResource(R.drawable.bee),
        contentDescription = "bee",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(dimen_64)
            .clip(CircleShape)
            .background(color = color)

    )
}

@PreviewLightDark
@Composable
fun RoundedImagePreview() {
    BeeRaceTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            RoundedImage(
                color = Color(hexToArgb("#183da3"))
            )
        }
    }
}