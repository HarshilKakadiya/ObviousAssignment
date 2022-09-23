package com.harshil.obviousassignment.ui.activity.details

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.harshil.obviousassignment.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
internal class DetailsActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun testIsViewPagerVisible() {
        Espresso.onView(
            ViewMatchers.withId(R.id.vpImages)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

}