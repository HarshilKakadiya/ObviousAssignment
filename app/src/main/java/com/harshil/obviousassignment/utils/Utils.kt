package com.harshil.obviousassignment.utils

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object Utils {

    inline fun <reified T> convert(string: String?): T? {
        return if (string?.isNotEmpty() == true) {
            val type = object : TypeToken<T>() {}.type
            Gson().fromJson<T>(string, type)
        } else {
            null
        }
    }

    inline fun <reified T : Parcelable> Intent.parcelableArrayList(key: String): ArrayList<T>? = when {
        SDK_INT >= 33 -> getParcelableArrayListExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelableArrayListExtra(key)
    }

}