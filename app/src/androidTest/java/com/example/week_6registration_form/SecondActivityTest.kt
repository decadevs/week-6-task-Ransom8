package com.example.week_6registration_form

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SecondActivityTest {

    /**
     * This Rule enables me to declare val activityRule only once
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    /**
     * This Test checks if the second activity is in view
     */
    @Test
    fun testActivity_inView() {
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()))
        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    /**
     * This checks if all the views are visible
     */
    @Test
    fun test_allViews() {
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView3)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView4)).check(matches(isDisplayed()))
        onView(withId(R.id.genderView)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextTextEmailAddress2)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextTextPersonName3)).check(matches(isDisplayed()))
        onView(withId(R.id.editTextPhone2)).check(matches(isDisplayed()))
    }

    /**
     * Test navigation from SecondaryActivity to MainActivity
     */
    @Test
    fun test_backPress_toMainActivity() {
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()))
        pressBack()
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()))
    }
}