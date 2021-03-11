package com.dam.mynicestart10;

import android.content.Context;
import android.view.InputDevice;
import android.view.MotionEvent;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Tap;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.actionWithAssertions;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.dam.mynicestart10", appContext.getPackageName());
    }

    @Test
    public void activityLaunch() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.username)).check(matches(isDisplayed()));
    }

    private ViewAction click() {
        return actionWithAssertions(
                new GeneralClickAction(Tap.SINGLE, GeneralLocation.VISIBLE_CENTER, Press.FINGER,
                        InputDevice.SOURCE_UNKNOWN, MotionEvent.BUTTON_PRIMARY));
    }

    @Test
    public void textInputOutput() {
        onView(withId(R.id.username)).perform(
                typeText("This is a test."));
        onView(withId(R.id.button)).perform(click());

    }

}