package com.oligue.app.beerace.utils

fun hexToArgb(hex: String): Int {
    val argb = hex.replace("#", "FF")

    return argb.toLong(16).toInt()
}

fun convertToMilliseconds(timeInSeconds: Int) = timeInSeconds * 1000L

fun convertToSeconds(milliseconds: Long) = milliseconds / 1000

fun convertMillisecondsToUI(totalSeconds: Long): String {
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60

    return "$minutes : $seconds"
}