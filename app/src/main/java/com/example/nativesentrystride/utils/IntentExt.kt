@file:Suppress("DEPRECATION")

package com.example.nativesentrystride.utils

import android.content.Intent
import android.os.Parcelable

internal fun <T : Parcelable> Intent.getParcelableCompatibility(key: String, type: Class<T>): T? {
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(key, type)
    } else {
        getParcelableExtra(key)
    }
}
