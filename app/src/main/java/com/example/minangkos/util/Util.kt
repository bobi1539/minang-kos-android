package com.example.minangkos.util

import java.text.DecimalFormat

fun ElipsisString(value: String, maxLength: Int): String {
    return if (value.length > maxLength) {
        value.substring(0, maxLength) + "..."
    } else {
        value
    }
}

fun StringThousandSeparator(value: Float) : String {
    val formatter = DecimalFormat("#,###")
    return formatter.format(value.toInt()).replace(",", ".")
}