package at.swt.hotel;


import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    /*@Test
    public void FirstTestActivity() {
        // Type text and then press the button.
        onView(withId(R.id.edit_location))
                .perform(typeText("Hello"), closeSoftKeyboard());
        onView(withId(R.id.imageMainSearch)).perform(click());
        onView(withId(R.id.edit_location))
                .check(matches(withText("Hello")));
    }*/
    @Test
    public void LoginTestActivity() {
        // Type text and then press the button.
        onView(withId(R.id.btn_Login_main)).perform(click());
        onView(withId(R.id.editUserName))
                .perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.editPassword))
                .perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.editUserName))
                .check(matches(withText("admin")));
        onView(withId(R.id.editPassword))
                .check(matches(withText("password")));
        onView(withId(R.id.btn_login_loginactivity)).perform(click());

    }

    @Test
    public void HotelViewTestActivity() {
        // Type text and then press the button.
        onView(withId(R.id.btn_sort)).perform(click());
        onView(ViewMatchers.withId(R.id.scrollHotel))
                .perform(ViewActions.swipeUp())
                .check(matches(isDisplayed()));
    }

    @Test
    public void FilterHotelTestActivityTest() {
        // Type text and then press the button.
        onView(withId(R.id.btn_filter)).perform(click());
        onView(withId(R.id.editFilterLocation))
                .perform(typeText("Graz"), closeSoftKeyboard());
        onView(withId(R.id.btnFilterSearch)).perform(click());

        onView(ViewMatchers.withId(R.id.hotel_list))
                .perform(ViewActions.swipeUp())
                .check(matches(isDisplayed()));
    }
}