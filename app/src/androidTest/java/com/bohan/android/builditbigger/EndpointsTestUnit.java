package com.bohan.android.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Bo Han.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndpointsTestUnit extends AndroidTestCase {
    String TAG = EndpointsTask.class.getSimpleName();
    @Rule
    public ActivityTestRule<MainActivity> myTestRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void testLoadingJoke() throws Exception {
        EndpointsTaskTest asyncTest =  new EndpointsTaskTest();
        asyncTest.execute(InstrumentationRegistry.getContext());
        String joke = asyncTest.get(6, TimeUnit.SECONDS);
        Assert.assertTrue(!joke.equals(""));
    }

    @Test
    public void testResponse() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.jokes_text_view)).check(matches(isDisplayed()));
    }

}


