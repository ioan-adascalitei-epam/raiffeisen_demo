package com.raiffeisen.app.util.extensions

import java.text.SimpleDateFormat
import java.util.Date

fun Date.toSimpleHourFormat(): String? {
    val formatter = SimpleDateFormat("HH:MM")
    return try {
        formatter.format(this)
    } catch (e: Exception) {
        null
    }
}