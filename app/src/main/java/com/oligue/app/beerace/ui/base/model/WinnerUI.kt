package com.oligue.app.beerace.ui.base.model

import kotlinx.serialization.Serializable

@Serializable
data class WinnerUI(
    val beeName: String,
    val color: String,
)
