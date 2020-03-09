package com.arpaul.sampletdd.ui.login;

import android.content.Context;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.arpaul.sampletdd.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
@LargeTest
public class LoginActivityTest {

    @Mock
    Context mMockContext;

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setup() {
        mMockContext = Mockito.mock(Context.class);
        Mockito.when(mMockContext.getApplicationContext()).thenReturn(mMockContext);
    }

    @Test
    public void testUserNameHintVisibility() {
        //check hint visibility
        onView(ViewMatchers.withId(R.id.edtUserName)).check(matches(withHint("Username")));
        //enter name
        onView(withId(R.id.edtUserName)).perform(typeText("Aritra"));
        closeSoftKeyboard();
        onView(withId(R.id.edtUserName)).check(matches(withText("Aritra")));
    }

    @Test
    public void testPasswordHintVisibility() {
        //check hint visibility
        onView(withId(R.id.edtPasssword)).check(matches(withHint("Password")));
        //enter name
        onView(withId(R.id.edtPasssword)).perform(typeText("Aritra"));
        closeSoftKeyboard();
        onView(withId(R.id.edtPasssword)).check(matches(withText("Aritra")));
    }

    @Test
    public void testButtonClick() {
        // enter name
        onView(withId(R.id.edtUserName)).perform(typeText("Aritra"));
        closeSoftKeyboard();

        onView(withId(R.id.edtPasssword)).perform(typeText("Aritra"));
        closeSoftKeyboard();
        //clear text
        onView(withText("Login")).perform(click());
        // check hint visbility after text is cleared
//        onView(withId(R.id.edtUserName)).check(matches(withHint("Enter Name")));
    }
}