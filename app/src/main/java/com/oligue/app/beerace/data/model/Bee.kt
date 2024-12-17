package com.oligue.app.beerace.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Bee(
    val color: String,
    val name: String
)