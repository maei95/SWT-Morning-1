package at.swt.hotel;

import android.widget.ListView;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityFilterPriceTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void FilterPriceTest() {

        onView(withId(R.id.btn_filter)).perform(click());
        // intended(hasComponent(MainActivity.class.getName()));

        onView(withId(R.id.editFilterLocation))
                .perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.filter_scrollview))
                .perform(ViewActions.swipeUp())
                .check(matches(isDisplayed()));

        onView(withId(R.id.priceToggle1)).perform(click());
        onView(withId(R.id.priceToggle2)).perform(click());
        onView(withId(R.id.priceToggle3)).perform(click());

        onView(withId(R.id.applyFilterButton)).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.hotel_list))
                .atPosition(0)
                .perform(click())
                .check(matches(isDisplayed()));

    }

    @Test
    public void FilterPriceAllTest() {

        onView(withId(R.id.btn_filter)).perform(click());
        // intended(hasComponent(MainActivity.class.getName()));

        onView(withId(R.id.editFilterLocation))
                .perform(typeText(""), closeSoftKeyboard());

        onView(withId(R.id.filter_scrollview))
                .perform(ViewActions.swipeUp())
                .check(matches(isDisplayed()));

        onView(withId(R.id.priceToggle1)).perform(click());
        onView(withId(R.id.priceToggle2)).perform(click());
        onView(withId(R.id.priceToggle3)).perform(click());
        onView(withId(R.id.priceToggle4)).perform(click());
        onView(withId(R.id.priceToggle5)).perform(click());

        onView(withId(R.id.applyFilterButton)).perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.hotel_list))
                .atPosition(2)
                .perform(click())
                .check(matches(isDisplayed()));

    }

}


