package com.harshil.obviousassignment.ui.activity.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.harshil.obviousassignment.R
import com.harshil.obviousassignment.custom.ViewPager2Actions
import com.harshil.obviousassignment.utils.FakeData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val itemNumber = 3
    private val item = FakeData.imagesList[itemNumber]

    /*
    * Recycler view is visible or not
    * */
    @Test
    fun testIsRecyclerViewVisible() {
        Espresso.onView(
            ViewMatchers.withId(R.id.rvImages)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    /*
    * Select item from recycler view
    * Navigate to images details screen
    * */
    @Test
    fun testSelectItemIsImageDetailsVisible() {

        // Click of the item
        Espresso.onView(
            ViewMatchers.withId(R.id.rvImages)
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImagesAdapter.ImagesViewHolder>(
                itemNumber,
                ViewActions.click()
            )
        )

        // checked click item is visible on view pager or not
        Espresso.onView(
            ViewMatchers.withId(R.id.tvTitle)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    item.title
                )
            )
        )

//        // checked click item is visible on view pager or not
//        // FAILED SCENARIO
//        Espresso.onView(
//            ViewMatchers.withId(R.id.tvTitle)
//        ).check(
//            ViewAssertions.matches(
//                ViewMatchers.withText(
//                    "any fake title"
//                )
//            )
//        )
    }

    /*
    * Select item from recycler view and navigate to images details screen
    * Swipe viewpager
    * */
    @Test
    fun testViewpagerSwipe() {

        // Click of the item
        Espresso.onView(
            ViewMatchers.withId(R.id.rvImages)
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImagesAdapter.ImagesViewHolder>(
                itemNumber,
                ViewActions.click()
            )
        )

        // checked click item is visible on view pager or not
        Espresso.onView(
            ViewMatchers.withId(R.id.tvTitle)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    item.title
                )
            )
        )

        // swipe item to check the functionality
        (1..5).map {

            // Go to next item of view pager
            Espresso.onView(
                ViewMatchers.withId(R.id.vpImages)
            ).perform(
                ViewPager2Actions.scrollRight(true)

            )

            // check the new item is correct or not
            Espresso.onView(
                ViewMatchers.withId(R.id.tvTitle)
            ).check(
                ViewAssertions.matches(
                    ViewMatchers.withText(
                        FakeData.imagesList[itemNumber + it].title
                    )
                )
            )
        }
    }

    /*
    * Select item from recycler view and navigate to images details screen
    * Check the visible item is correct or not
    * on back press
    * */
    @Test
    fun testItemClickCheckItemOnBackPress() {

        // Click of the item
        Espresso.onView(
            ViewMatchers.withId(R.id.rvImages)
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImagesAdapter.ImagesViewHolder>(
                itemNumber,
                ViewActions.click()
            )
        )

        // checked click item is visible on view pager or not
        Espresso.onView(
            ViewMatchers.withId(R.id.tvTitle)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    item.title
                )
            )
        )

        pressBack()
    }

}