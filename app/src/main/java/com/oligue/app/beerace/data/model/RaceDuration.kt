package com.oligue.app.beerace.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RaceDuration(
    val timeInSeconds: Int
)
