package at.swt.hotel;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityFilterTest {

    private static final String MESSAGE = "Algarve";

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ChangeText_sameActivity() {
        onView(withId(R.id.btn_filter))
                .perform(click());
        onView(withId(R.id.editFilterLocation))
                .perform(typeText(MESSAGE), closeSoftKeyboard());
        onView(withId(R.id.editFilterLocation))
                .check(matches(withText(MESSAGE)));
        onView(withId(R.id.btnFilterSearch))
                .perform(click());



        //onView(withId(R.id.send_message)).perform(click())

        // Type text and then press the button.
        //onView(withId(R.id.editTextUserInput))
        //        .perform(typeText(stringToBetyped), closeSoftKeyboard());
        //onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed.
        //onView(withId(R.id.textToBeChanged))
        //        .check(matches(withText(stringToBetyped)));
    }

    @Test
    public void PriceToggles_sameActivity() {
        onView(withId(R.id.btn_filter))
                .perform(click());

        onView(withId(R.id.editFilterLocation))
                .perform(typeText("Wien Hotel"), closeSoftKeyboard());

        onView(withId(R.id.priceToggle1))
                .perform(click());


        onView(withId(R.id.priceToggle1))
                .check(matches(isChecked()));

        onView(withId(R.id.priceToggle2))
                .perform(click());
        onView(withId(R.id.priceToggle2))
                .check(matches(isChecked()));

        onView(withId(R.id.priceToggle3))
                .perform(click());
        onView(withId(R.id.priceToggle3))
                .check(matches(isChecked()));

        onView(withId(R.id.priceToggle4))
                .perform(click());
        onView(withId(R.id.priceToggle4))
                .check(matches(isChecked()));

        onView(withId(R.id.priceToggle5))
                .perform(click());
        onView(withId(R.id.priceToggle5))
                .check(matches(isChecked()));
    }

    @Test
    public void CategoryToggles_sameActivity() {
        onView(withId(R.id.btn_filter))
                .perform(click());
        onView(withId(R.id.editFilterLocation))
                .perform(typeText("Test Hotel"), closeSoftKeyboard());
        onView(withId(R.id.categoryToggle1))
                .perform(click());
        onView(withId(R.id.categoryToggle1))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle2))
                .perform(click());
        onView(withId(R.id.categoryToggle2))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle3))
                .perform(click());
        onView(withId(R.id.categoryToggle3))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle4))
                .perform(click());
        onView(withId(R.id.categoryToggle4))
                .check(matches(isChecked()));
    }


    @Test
    public void ActivitiesToggles_sameActivity() {

        onView(withId(R.id.btn_filter))
                .perform(click());
        onView(withId(R.id.editFilterLocation))
                .perform(typeText("Graz Hotel"), closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.filter_scrollview))
                .perform(ViewActions.swipeUp())
                .check(matches(isDisplayed()));

        onView(withId(R.id.activityToggleButton1))
                .perform(click());
        onView(withId(R.id.activityToggleButton1))
                .check(matches(isChecked()));

        onView(withId(R.id.activityToggleButton2))
                .perform(click());
        onView(withId(R.id.activityToggleButton2))
                .check(matches(isChecked()));

        onView(withId(R.id.activityToggleButton3))
                .perform(click());
        onView(withId(R.id.activityToggleButton3))
                .check(matches(isChecked()));

        onView(withId(R.id.activityToggleButton4))
                .perform(click());
        onView(withId(R.id.activityToggleButton4))
                .check(matches(isChecked()));

        onView(withId(R.id.activityToggleButton5))
                .perform(click());
        onView(withId(R.id.activityToggleButton5))
                .check(matches(isChecked()));

        onView(withId(R.id.activityToggleButton6))
                .perform(click());
        onView(withId(R.id.activityToggleButton6))
                .check(matches(isChecked()));

    }


            /*onView(ViewMatchers.withId(R.id.filter_scrollview))
                .perform(ViewActions.swipeDown())
                .check(matches(isDisplayed()));
         */
        /*onView(withId(R.id.priceToggle1))
                .perform(scrollTo(), click());*/
}