package com.raiffeisen.app.util.extensions

import java.text.SimpleDateFormat
import java.util.Date

fun String.toSimpleDate(): Date? {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    return try {
        formatter.parse(this)
    } catch (e: Exception) {
        null
    }
}