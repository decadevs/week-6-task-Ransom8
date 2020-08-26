package com.example.week_6registration_form

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import junit.textui.TestRunner.main
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.JUnitCore.main
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    /**
     * Test if main activity comes to view when app is launched
     */
    @Test
    fun testActivity_inView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.mainActivity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Test whether the second activity comes in view when the reserve_your_spot button
     * is pressed
     */
    @Test
    fun test_navToSecondaryActivity() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.button)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.secondActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * This checks if all the views are visible
     */
    @Test
    fun test_allViews() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(withId(R.id.imageView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.imageView3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.imageView4)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.editTextEmailAddress)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.editTextPersonName)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.editTextPhone)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.spinner)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.button)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}