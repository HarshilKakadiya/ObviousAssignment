package com.harshil.obviousassignment

import android.content.Context
import android.content.res.AssetManager
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.AndroidEntryPoint
import junit.framework.TestCase

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : TestCase() {

    lateinit var instrumentationContext: Context
    lateinit var assetManager : AssetManager

    @Before
    public override fun setUp() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().targetContext
        assetManager = instrumentationContext.assets
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.harshil.obviousassignment", appContext.packageName)
    }

    @Test
    fun readJsonFromFile() {
        val jsonString: String = assetManager.open("data.json")
            .bufferedReader()
            .use { it.readText() }
        assertTrue(jsonString.isNotBlank())
    }

}