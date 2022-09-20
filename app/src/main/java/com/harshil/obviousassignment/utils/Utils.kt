package com.harshil.obviousassignment.utils

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

}