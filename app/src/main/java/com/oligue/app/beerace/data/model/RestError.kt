package com.oligue.app.beerace.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RestError(
    val captchaUrl: String
)
