package at.swt.hotel;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
public class ActivityDetailTest {

    private static final String MESSAGE = "This hotel blablablab...";

    @Rule
    public ActivityTestRule<DetailActivity> activityRule
            = new ActivityTestRule<>(DetailActivity.class);

    /*@Test
    public void ChangeText_sameActivity() {

        onView(withId(R.id.txtDescription))
                .perform(typeText(MESSAGE), closeSoftKeyboard());
        onView(withId(R.id.txtDescription))
                .check(matches(withText(MESSAGE)));
    }*/

    @Test
    public void CategoryToggles_sameActivity() {
        onView(ViewMatchers.withId(R.id.scrollViewActivityDetail))
                .perform(ViewActions.swipeUp())
                .check(matches(isDisplayed()));

        onView(withId(R.id.categoryToggle1Detail))
                .perform(click());
        onView(withId(R.id.categoryToggle1Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle2Detail))
                .perform(click());
        onView(withId(R.id.categoryToggle2Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle3Detail))
                .perform(click());
        onView(withId(R.id.categoryToggle3Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle4Detail))
                .perform(click());
        onView(withId(R.id.categoryToggle4Detail))
                .check(matches(isChecked()));
    }

    @Test
    public void ActivitiesToggles_sameActivity() {

        onView(withId(R.id.activityToggleButton6Detail))
                .perform(scrollTo());

        onView(withId(R.id.activityToggleButton1Detail))
                .perform(click());
        onView(withId(R.id.activityToggleButton1Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.activityToggleButton2Detail))
                .perform(click());
        onView(withId(R.id.activityToggleButton2Detail))
                .check(matches(isNotChecked()));

        onView(withId(R.id.activityToggleButton3Detail))
                .perform(click());
        onView(withId(R.id.activityToggleButton3Detail))
                .check(matches(isNotChecked()));

        onView(withId(R.id.activityToggleButton4Detail))
                .perform(click());
        onView(withId(R.id.activityToggleButton4Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.activityToggleButton5Detail))
                .perform(click());
        onView(withId(R.id.activityToggleButton5Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.activityToggleButton6Detail))
                .perform(click());
        onView(withId(R.id.activityToggleButton6Detail))
                .check(matches(isChecked()));

    }

}
