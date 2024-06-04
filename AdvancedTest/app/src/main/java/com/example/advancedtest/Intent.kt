package com.example.advancedtest

import android.content.Intent
import android.os.Build
import android.os.Parcelable
import java.io.Serializable

fun <T : Serializable?> Intent.getSerializable(key: String, m_class: Class<T>): T {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializableExtra(key, m_class)!!
    } else {
        this.getSerializableExtra(key) as T
    }
}

fun <T:Parcelable?> Intent.getParcelable(key: String,m_class: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getParcelableExtra(key, m_class)!!
    } else {
        this.getParcelableExtra(key)
    }
}
