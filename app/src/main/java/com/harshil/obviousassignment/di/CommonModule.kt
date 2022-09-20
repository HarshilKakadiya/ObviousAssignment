package com.harshil.obviousassignment.di

import android.app.Application
import android.content.res.AssetManager
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Singleton
    @Provides
    fun getAssets(context: Application): AssetManager =
        context.assets

    @Singleton
    @Provides
    fun getGson() = Gson()

}