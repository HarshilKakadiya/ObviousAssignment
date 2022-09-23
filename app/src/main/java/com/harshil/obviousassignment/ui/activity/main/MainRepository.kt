package com.harshil.obviousassignment.ui.activity.main

import android.content.res.AssetManager
import com.harshil.obviousassignment.models.ImagesModelItem
import com.harshil.obviousassignment.utils.Utils.convert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val assetManager: AssetManager,
) {

    suspend fun getJsonData() = withContext(Dispatchers.IO) {
        val jsonString = assetManager.open("data.json")
            .bufferedReader()
            .use { it.readText() }

        return@withContext convert<MutableList<ImagesModelItem>>(jsonString)
    }

}