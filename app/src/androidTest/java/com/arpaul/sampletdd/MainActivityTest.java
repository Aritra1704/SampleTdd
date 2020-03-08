package com.arpaul.sampletdd;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testHintVisibility() {
        //check hint visibility
        onView(withId(R.id.edtName)).check(matches(withHint("Enter Name")));
        //enter name
        onView(withId(R.id.edtName)).perform(typeText("Aritra"));
        closeSoftKeyboard();
        onView(withId(R.id.edtName)).check(matches(withText("Aritra")));
    }

    @Test
    public void testButtonClick() {
        // enter name
        onView(withId(R.id.edtName)).perform(typeText("Aritra"));
        closeSoftKeyboard();
        //clear text
        onView(withText("Clear text")).perform(click());
        // check hint visbility after text is cleared
        onView(withId(R.id.edtName)).check(matches(withHint("Enter Name")));
    }
}