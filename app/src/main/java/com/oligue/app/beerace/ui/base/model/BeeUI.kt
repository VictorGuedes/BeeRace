package com.oligue.app.beerace.ui.base.model

import kotlinx.serialization.Serializable

@Serializable
data class BeeResponseUI(
    val beeList: List<BeeUI>
)

@Serializable
data class BeeUI(
    val color: String,
    val name: String,
    val positionString: String,
    val position: Int
)
