package com.example.week_6registration_form

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
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
        Espresso.onView(withId(R.id.secondActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    /**
     * This checks if all the views are visible
     */
    @Test
    fun test_allViews() {
        val activityScenario = ActivityScenario.launch(SecondActivity::class.java)
        Espresso.onView(withId(R.id.imageView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.imageView3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.imageView4)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.genderView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.editTextTextEmailAddress2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.editTextTextPersonName3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.editTextPhone2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}